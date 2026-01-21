package es210126;

public class Smartphone extends Prodotto implements Scontabile {
    
    private int memoriaGB;

    public Smartphone(String codice, String nome, double prezzo, int memoriaGB) {
        super(codice, nome, prezzo);
        this.memoriaGB = memoriaGB;
    }
    
    public int getMemoriaGB() {
        return memoriaGB;
    }

    public double prezzoScontato(double percentuale) {
        return getPrezzo() * (1 - percentuale / 100);
    }

    public String getDescrizione() {
        return "Smartphone con " + memoriaGB + " GB di memoria";
    }

    public String toString() {
        return super.toString() + " | " + memoriaGB + " GB";
    }
}
