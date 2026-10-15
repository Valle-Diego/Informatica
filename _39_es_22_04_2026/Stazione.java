// File: Stazione.java
import java.util.ArrayList;

public class Stazione {

    private String nome;                        // es. "Milano Centrale"
    private ArrayList<Treno> treniPresenti;     // lista dei treni in stazione

    public Stazione(String nome) {
        this.nome = nome;
        this.treniPresenti = new ArrayList<>(); // lista inizialmente vuota
    }

    // Aggiunge un treno alla stazione
    public void aggiungiTreno(Treno t) {
        treniPresenti.add(t);
        System.out.println(t.getCodice() + " arrivato a " + nome);
    }

    // Stampa tutti i treni presenti con destinazione e posti liberi
    public void stampaPartenze() {
        System.out.println("=== Partenze da " + nome + " ===");
        for (Treno t : treniPresenti) {
            System.out.println("  " + t.getCodice()
                    + " -> " + t.getDestinazione()
                    + " (posti liberi: " + t.getPostiLiberi() + ")");
        }
    }

    // Conta e restituisce quanti treni sono attualmente in ritardo -- Esercizio 4
    public int contaTreniInRitardo() {
        int contatore = 0;
        for (Treno t : treniPresenti) {
            if (t.isInRitardo()) {
                contatore++;
            }
        }
        return contatore;
    }

    public String getNome() { return nome; }
}
