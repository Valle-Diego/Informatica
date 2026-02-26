package es080126.es1;

public class Persona {
    String nome;
    int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void descrizione() {
        System.out.println("Mi chiamo " + nome + " e ho " + eta + " anni");
    }
}

