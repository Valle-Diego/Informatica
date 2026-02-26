package es221025n1;

public class Persona {
    private String CF;
    private String n;
    private String c;

    public Persona() {
    }

    public Persona(String CF, String n, String c) {
        this.CF = CF;
        this.n = n;
        this.c = c;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getNome() {
        return n;
    }

    public void setNome(String n) {
        this.n = n;
    }

    public String getCognome() {
        return c;
    }

    public void setCognome(String c) {
        this.c = c;
    }

    public String toString() {
        return "Persona{" + "codiceFiscale='" + CF + ", nome=" + n + ", cognome=" + c + '}';
    }
}
