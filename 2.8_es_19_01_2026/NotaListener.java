package es190126;

public class NotaListener extends RegistroAdapter {

    public void onNota(String studente, String testoNota) {
        System.out.println(" Nota disciplinare per " + studente);
        System.out.println("Motivo: " + testoNota);
    }
}
