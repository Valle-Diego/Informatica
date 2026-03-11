package _24_es_11_12_2025;

public interface Spazio {
    String getNome();
    double calcolaCosto(int ore, boolean giornataIntera);
    boolean isDisponibile(java.util.List<Prenotazione> prenotazioni, int inizio, int fine);
}
