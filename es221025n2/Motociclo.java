package es221025n2;

public class Motociclo extends Veicolo {
    private int cv; // es. 50, 125, 1000

    public Motociclo(String t, String m, String mod, int cv) {
        super(t, m, mod);
        this.cv = cv;
    }

    public int getCV() {
        return cv;
    }

    public void setCV(int cv) {
        this.cv = cv;
    }

    public String toString() {
        return "Motociclo{" +
                "targa='" + getT() + '\'' +
                ", marca='" + getM() + '\'' +
                ", modello='" + getMod() + '\'' +
                ", cilindrata=" + cv +
                ", guasto=" + isBroke() +
                '}';
    }
}
