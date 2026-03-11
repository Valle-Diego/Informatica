package _28_es_19_01_2026;

public class NotaListener extends RegistroAdapter {

    public void onNota(String studente, String testoNota) {
        System.out.println(" Nota disciplinare per " + studente);
        System.out.println("Motivo: " + testoNota);
    }
}
