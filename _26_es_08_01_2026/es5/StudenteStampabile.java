package _26_es_08_01_2026.es5;

public class StudenteStampabile extends Studente2 implements Stampabile {

    public StudenteStampabile(String nome, int eta, String classe) {
        super(nome, eta, classe);
    }

    public void stampa() {
        descrizione();
    }
}
