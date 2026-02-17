package es080126.es5;

public class Persona {
    protected String nome;
    protected int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void descrizione() {
        System.out.println("Persona: " + nome);
    }
}
