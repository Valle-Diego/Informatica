package es221025n2;

public class Vettura extends Veicolo {
    private String type; // es. "utilitaria", "station wagon", "SUV"

    public Vettura(String t, String m, String mod, String type) {
        super(t, m, mod);
        this.type = type;
    }

    public String getTipe() {
        return type;
    }

    public void setTipologia(String type) {
        this.type = type;
    }

    public String toString() {
        return "Vettura{" +
                "targa='" + getT() + '\'' +
                ", marca='" + getM() + '\'' +
                ", modello='" + getMod() + '\'' +
                ", tipologia='" + type + '\'' +
                ", guasto=" + isBroke() +
                '}';
    }
}
