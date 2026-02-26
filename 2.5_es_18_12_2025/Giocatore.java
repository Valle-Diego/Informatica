package es181225;

import java.util.*;

public class Giocatore extends Entita {
    private List<Abilita> abilitaApprese;
    
    public Giocatore(String nome, int maxPF, int attaccoBase, int difesaBase) {
        super(nome, maxPF, attaccoBase, difesaBase);
        this.abilitaApprese = new ArrayList<>();
    }
    
    public void imparaAbilita(Abilita abilita) {
        this.abilitaApprese.add(abilita);
        System.out.println(nome + " ha appreso l'abilità: " + abilita.getNome() + ".");
    }

    private List<String> getListaMosse() {
        List<String> mosse = new ArrayList<>();
        mosse.add("Attacco Base");
        for (Abilita ab : abilitaApprese) {
            mosse.add(ab.getNome());
        }
        return mosse;
    }

    

    public void turno(Combattente target) {
        System.out.println("Attenzione: Turno di Giocatore chiamato senza metodo interattivo.");
    }
    public void turno(Combattente target, Scanner scanner) {
        if (!isVivo()) return;

        System.out.println("\n--- Turno di " + nome + " ---");
    
        System.out.println("Stato attuale: " + this.toString());
        System.out.println("Avversario: " + ((Entita)target).nome + " (" + target.getPuntiFerita() + " PF)");
        
        List<String> opzioni = getListaMosse();
        int scelta = -1;
        
        while (scelta < 0 || scelta >= opzioni.size()) {
            System.out.println("\nScegli un'azione:");
            for (int i = 0; i < opzioni.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + opzioni.get(i));
            }
            
            System.out.print("Inserisci il numero dell'azione: ");
            
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt() - 1; 
                
                if (scelta < 0 || scelta >= opzioni.size()) {
                    System.out.println("Scelta non valida. Inserisci un numero tra 1 e " + opzioni.size() + ".");
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero intero.");
                scanner.next();
            }
        }
        
        if (scelta == 0) {
            attacca(target);
        } else {
            Abilita ab = abilitaApprese.get(scelta - 1);
            ab.usa(this, target);
        }
    }
}