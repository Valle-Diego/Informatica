package es101225;

// Ordine per asporto, senza sovrapprezzi
public class OrdineAsporto extends Ordine {

    public OrdineAsporto(PaymentMethod pm) {
        super(pm);
    }

    public double calcolaTotale() {
        // Totale uguale al totale base, arrotondato a 2 decimali
        return Math.round(getTotaleBase() * 100.0) / 100.0;
    }

    public String toString() {
        return "[ASPORTO] " + super.toString() + "Totale: " + calcolaTotale() + "\n";
    }
}
