package es181225;

public class Main {
    public static void main(String[] args) {
        // 1. Creazione del Giocatore e delle Abilità
        Giocatore eroe = new Giocatore("Sir Gareth", 200, 30, 10);
        Abilita colpoForte = new ColpoCritico();
        eroe.imparaAbilita(colpoForte);
        
        // 2. Creazione del Mostro
        Mostro orco = new Mostro("Orco Grugnito", 150, 25, 5);

        // 3. Avvio del Combattimento INTERATTIVO
        Combattimento.iniziaScontro(eroe, orco);
    }
}