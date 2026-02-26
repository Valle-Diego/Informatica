package es111225;

public class Prenotazione {
    private Spazio spazio;
    private int inizio;
    private int fine;

    public Prenotazione(Spazio spazio, int inizio, int fine) {
        this.spazio = spazio;
        this.inizio = inizio;
        this.fine = fine;
    }

    public Spazio getSpazio() {
        return spazio;
    }

    public boolean siSovrappone(int start, int end) {
        return !(end <= inizio || start >= fine);
    }

    public String toString() {
        return "Prenotazione: " + spazio.getNome() + " dalle " + inizio + " alle " + fine;
    }
}
