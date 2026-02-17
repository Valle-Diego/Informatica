package es190126;

public interface RegistroListener {

    void onAssenza(String studente);

    void onVoto(String studente, int voto);

    void onNota(String studente, String testoNota);
}
