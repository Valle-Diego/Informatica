package es101225;

// Ordine per consegna a domicilio con sovrapprezzo fisso
public class OrdineDomicilio extends Ordine {
    private String indirizzo;
    private final double sovrapprezzo = 3.50;

    public OrdineDomicilio(PaymentMethod pm, String indirizzo) {
        super(pm);
        this.indirizzo = indirizzo;
    }

    public double calcolaTotale() {
        // Totale base + sovrapprezzo consegna
        return Math.round((getTotaleBase() + sovrapprezzo) * 100.0) / 100.0;
    }

    public String toString() {
        return "[DOMICILIO] " + super.toString() +
               "Indirizzo: " + indirizzo + "\n" +
               "Sovrapprezzo: " + sovrapprezzo + "\n" +
               "Totale: " + calcolaTotale() + "\n";
    }
}

