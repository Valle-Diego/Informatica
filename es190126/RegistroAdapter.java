package es190126;

public abstract class RegistroAdapter implements RegistroListener {

    public void onAssenza(String studente) {
        // metodo vuoto
    }

    public void onVoto(String studente, int voto) {
        // metodo vuoto
    }

    public void onNota(String studente, String testoNota) {
        // metodo vuoto
    }
}
