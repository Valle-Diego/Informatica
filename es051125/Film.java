package es051125;

// Classe che rappresenta un film
public class Film {
    private String t; // titolo
    private String r; // regista
    private int a;    // anno

    // Costruttore
    public Film(String t, String r, int a) {
        this.t = t;
        this.r = r;
        this.a = a;
    }

    // Getter
    public String getTitolo() { return t; }
    public String getRegista() { return r; }
    public int getAnno() { return a; }

    // Rappresentazione testuale del film
    public String toString() {
        return t + " (" + a + ") - " + r;
    }
}
