package Albergo;

public class Stanza {
    private int nStanza;
    private double pBase;
    private boolean occupata;

    public Stanza(int nStanza, double pBase) {
        this.nStanza = nStanza;
        this.pBase = pBase;
        this.occupata = false;
    }

    public int getNStanza() {
        return nStanza;
    }

    public double getPBase() {
        return pBase;
    }

    public boolean isOccupata() {
        return occupata;
    }

    public void setOccupata(boolean occupata) {
        this.occupata = occupata;
    }

    @Override
    public String toString() {
        return "Stanza n°" + nStanza +
               " (prezzo base: " + pBase + " euro, " +
               (occupata ? "Occupata" : "Libera") + ")";
    }
}
