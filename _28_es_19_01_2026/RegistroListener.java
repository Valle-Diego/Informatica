package _28_es_19_01_2026;

public interface RegistroListener {

    void onAssenza(String studente);

    void onVoto(String studente, int voto);

    void onNota(String studente, String testoNota);
}
