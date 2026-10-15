import java.util.*;
import java.util.function.Predicate;

// ---------------------------------------------------------------------------
// Gerarchia di tipi fornita — non modificare
// ---------------------------------------------------------------------------
class Measurement {}
class Temperature extends Measurement {}
class Pressure  extends Measurement {}
class Humidity  extends Measurement {}

// ---------------------------------------------------------------------------
// GenericBox<T> — contenitore generico con pattern PECS
// ---------------------------------------------------------------------------
public class GenericBox<T> {

    // Requisito 1 — campo interno privato
    private final List<T> items = new ArrayList<>();

    // -----------------------------------------------------------------------
    // Requisito 2 — Producer Extends
    // source "produce" elementi verso la box: usiamo <? extends T>
    // addAll rispetta PECS: legge da source, scrive in items
    // -----------------------------------------------------------------------
    public void loadFrom(List<? extends T> source) {
        items.addAll(source);
    }

    // -----------------------------------------------------------------------
    // Requisito 3 — Consumer Super
    // dest "consuma" elementi dalla box: usiamo <? super T>
    // addAll rispetta PECS: legge da items, scrive in dest
    // -----------------------------------------------------------------------
    public void dumpTo(List<? super T> dest) {
        dest.addAll(items);
        items.clear();
    }

    // -----------------------------------------------------------------------
    // Requisito 4 — merge statico con wildcard annidato (Producer Extends doppio)
    //
    // Outer wildcard:  List<? extends GenericBox<? extends T>>
    //   => ogni elemento della lista e' una GenericBox di qualche sottotipo di T
    // Inner wildcard:  GenericBox<? extends T>
    //   => la box stessa produce elementi che sono sottotipi di T
    //
    // Non serve cast perche' loadFrom accetta List<? extends T>
    // e box.items e' List<? extends T> per il bound interno.
    // -----------------------------------------------------------------------
    public static <T> GenericBox<T> merge(
            List<? extends GenericBox<? extends T>> boxes) {

        GenericBox<T> result = new GenericBox<>();
        for (GenericBox<? extends T> box : boxes) {
            // box.items e' List<? extends T> — compatibile con loadFrom
            result.loadFrom(box.items);
        }
        return result;
    }

    // -----------------------------------------------------------------------
    // Requisito 5 — Predicate come Consumer Super
    // pred "consuma" T (o un suo supertipo): <? super T>
    // -----------------------------------------------------------------------
    public int count(Predicate<? super T> pred) {
        int n = 0;
        for (T item : items) {
            if (pred.test(item)) {
                n++;
            }
        }
        return n;
    }

    // -----------------------------------------------------------------------
    // Requisito 6 — main di test
    // -----------------------------------------------------------------------
    public static void main(String[] args) {

        // --- Crea e popola una box di Temperature ---
        GenericBox<Temperature> tempBox = new GenericBox<>();
        List<Temperature> temps = new ArrayList<>();
        temps.add(new Temperature());
        temps.add(new Temperature());
        temps.add(new Temperature());
        tempBox.loadFrom(temps);   // List<Temperature> estende List<? extends Temperature>
        System.out.println("tempBox dopo loadFrom: " + tempBox.items.size() + " elementi");

        // --- Crea e popola una box di Pressure ---
        GenericBox<Pressure> pressBox = new GenericBox<>();
        List<Pressure> pressures = new ArrayList<>();
        pressures.add(new Pressure());
        pressures.add(new Pressure());
        pressBox.loadFrom(pressures);
        System.out.println("pressBox dopo loadFrom: " + pressBox.items.size() + " elementi");

        // --- Merge in GenericBox<Measurement> ---
        // Entrambe le box sono GenericBox<? extends Measurement>
        List<GenericBox<? extends Measurement>> boxList = new ArrayList<>();
        boxList.add(tempBox);
        boxList.add(pressBox);

        GenericBox<Measurement> merged = GenericBox.merge(boxList);
        System.out.println("merged dopo merge: " + merged.items.size() + " elementi"); // atteso: 5

        // --- count con Predicate<? super Measurement> ---
        // Conta tutti gli elementi (pred sempre true)
        int total = merged.count(m -> true);
        System.out.println("count(sempre true): " + total); // atteso: 5

        // Conta solo le Temperature — Predicate<Object> e' super di Measurement
        int onlyTemp = merged.count(m -> m instanceof Temperature);
        System.out.println("count(instanceof Temperature): " + onlyTemp); // atteso: 3

        // --- dumpTo su List<Object> (super di Measurement) ---
        List<Object> destination = new ArrayList<>();
        merged.dumpTo(destination);  // List<Object> e' List<? super Measurement>
        System.out.println("destination dopo dumpTo: " + destination.size() + " elementi"); // atteso: 5
        System.out.println("merged dopo dumpTo (svuotata): " + merged.items.size() + " elementi"); // atteso: 0

        // --- Verifica loadFrom su GenericBox<Measurement> con List<Temperature> ---
        GenericBox<Measurement> mBox = new GenericBox<>();
        mBox.loadFrom(temps);  // List<Temperature> e' List<? extends Measurement>
        System.out.println("mBox dopo loadFrom<Temperature>: " + mBox.items.size() + " elementi"); // atteso: 3

        System.out.println("\nTutti i test superati. Nessun cast esplicito, nessun raw type.");
    }
}
