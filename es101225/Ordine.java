package es101225;

// Classe astratta che rappresenta un ordine generico
public abstract class Ordine {
    private static int counter = 1; // contatore automatico ID ordine
    protected int id;
    protected PaymentMethod paymentMethod;

    // Array semplici per memorizzare items e quantità
    protected MenuItem[] items = new MenuItem[100];
    protected int[] quantita = new int[100];
    protected int count = 0; // numero di item nell'ordine

    public Ordine(PaymentMethod pm) {
        this.id = counter++;
        this.paymentMethod = pm;
    }

    // Aggiunge un item all'ordine
    public void aggiungiItem(MenuItem item, int q) {
        if (q <= 0) return;

        // Se l'item esiste già, somma la quantità
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                quantita[i] += q;
                return;
            }
        }
        // Altrimenti aggiungi nuovo item
        items[count] = item;
        quantita[count] = q;
        count++;
    }

    // Calcola il totale senza eventuali extra
    public double getTotaleBase() {
        double totale = 0;
        for (int i = 0; i < count; i++) {
            totale += items[i].getPrezzo() * quantita[i];
        }
        return totale;
    }

    // Metodo astratto per calcolare il totale finale (override nelle sottoclassi)
    public abstract double calcolaTotale();

    // Rappresentazione testuale dell'ordine
    public String toString() {
        String s = "Ordine #" + id + "\n";
        for (int i = 0; i < count; i++) {
            s += items[i].name() + " x" + quantita[i] + " @ " + items[i].getPrezzo() + "\n";
        }
        s += "Totale base: " + getTotaleBase() + "\n";
        s += "Metodo pagamento: " + paymentMethod + "\n";
        return s;
    }
}
