package _28_es_19_01_2026;

public class RegistroElettronico {

    private RegistroListener listener;

    public void setListener(RegistroListener listener) {
        this.listener = listener;
    }

    public void inserisciNota(String studente, String nota) {
        if (listener != null) {
            listener.onNota(studente, nota);
        }
    }
}
