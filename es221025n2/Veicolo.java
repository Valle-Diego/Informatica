package es221025n2;

public class Veicolo {
    private String t;
    private String m;
    private String mod;
    private boolean broke;

    // Costruttore
    public Veicolo(String t, String m, String mod) {
        this.t = t;
        this.m = m;
        this.mod = mod;
        this.broke = false; // di default non è guasto
    }

    // Getter e Setter
    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getMod() {
        return m;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public boolean isBroke() {
        return broke;
    }

    public void setBroke(boolean broke) {
        this.broke = broke;
    }

    public String toString() {
        return "Veicolo{" +
                "targa='" + t + '\'' +
                ", marca='" + m + '\'' +
                ", modello='" + mod + '\'' +
                ", guasto=" + broke +
                '}';
    }
}
