package es301025;

public class EBook extends Libro {

    private double dF; // Dimensione file in MB

    // Costruttore
    public EBook(String t, String a, int y, double dF) {
        super(t, a, y);
        this.dF = dF;
    }

    // Getter
    public double getDF() {
        return dF;
    }

    // toString
    public String toString() {
        return super.toString() + ", Dimensione file: " + dF + " MB";
    }
}
