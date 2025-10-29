package es221025n1;

public class Dipendente extends Persona {
    private int AA;
    private double s;

    // Costruttore vuoto
    public Dipendente() {
        super();
    }

    // Costruttore completo
    public Dipendente(String CF, String n, String c, int AA, double s) {
        super(CF, n, c);
        this.AA = AA;
        this.s = s;
    }

    // Getter e Setter
    public int getAA() {
        return AA;
    }

    public void setAA(int AA) {
        this.AA = AA;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    // Metodo per confrontare gli stipendi
    public boolean gPiuDi(Dipendente a) {
        return this.s > a.getS();
    }

    // Metodo visualizza (override di toString)
    public String toString() {
        return super.toString() + 
               ", annoAssunzione=" + AA + 
               ", stipendio=" + s;
    }
}
