package es181225;

public class Mostro extends Entita {

    public Mostro(String nome, int maxPF, int attaccoBase, int difesaBase) {
        super(nome, maxPF, attaccoBase, difesaBase);
    }

    public void turno(Combattente target) {
        if (!isVivo()) return;

        System.out.println("\n--- Turno di " + nome + " ---");
        attacca(target);
    }
}
