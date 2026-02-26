package es111225;

public interface Spazio {
    String getNome();
    double calcolaCosto(int ore, boolean giornataIntera);
    boolean isDisponibile(java.util.List<Prenotazione> prenotazioni,
                          int inizio, int fine);
}
