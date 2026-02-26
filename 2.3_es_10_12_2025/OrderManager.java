package es101225;

// Gestisce tutti gli ordini e il calcolo dell'incasso totale
public class OrderManager {
    private Ordine[] ordini = new Ordine[100];
    private int count = 0;

    public void addOrdine(Ordine o) {
        ordini[count++] = o;
    }

    // Somma totale di tutti gli ordini
    public double totaleIncasso() {
        double totale = 0;
        for (int i = 0; i < count; i++) {
            totale += ordini[i].calcolaTotale();
        }
        return totale;
    }

    public int numeroOrdini() {
        return count;
    }

    // Stampa tutti gli ordini
    public void stampaRiepilogo() {
        for (int i = 0; i < count; i++) {
            System.out.println(ordini[i]);
        }
        System.out.println("INCASSO TOTALE: " + totaleIncasso());
        System.out.println("ORDINI: " + numeroOrdini());
    }
}
