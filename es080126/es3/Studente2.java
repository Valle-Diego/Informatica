package es080126.es3;

public class Studente2 extends Persona {

    protected String classe;

    public Studente2(String nome, int eta, String classe) {
        super(nome, eta);
        this.classe = classe;
    }

    @Override
    public void descrizione() {
        System.out.println(nome + " - classe " + classe);
    }
}
