package es210126;

public class Laptop extends Prodotto{

    private double pollici;

    public Laptop(String codice, String nome, double prezzo, double pollici) {
        super(codice, nome, prezzo);
        this.pollici = pollici;
    }
    
    public double getPollici() {
        return pollici;
    }

    public String getDescrizione() {
        return "Laptop da " + pollici + " pollici";
    }
    public String toString() {
        return super.toString() + " | " + pollici;
    }
}
