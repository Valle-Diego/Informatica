package es301025;

public class Libro {

    private String t; // Titolo
    private String a; // Autore
    private int y;    // Anno di pubblicazione

    // Costruttore (t, a, y)
    public Libro(String t, String a, int y) {
        this.t = t;
        this.a = a;
        this.y = y;
    }

    // Getter
    public String getT() {
        return t;
    }

    public String getA() {
        return a;
    }

    public int getY() {
        return y;
    }

    // toString
    public String toString() {
        return "Titolo: " + t + ", Autore: " + a + ", Anno: " + y;
    }
}
