package es181225;

import java.util.Scanner; // Necessario qui

public class Combattimento {

    public static void iniziaScontro(Entita entita1, Entita entita2) {
        System.out.println("=========================================");
        System.out.println("INIZIO SCONTRO: " + entita1.nome + " vs " + entita2.nome);
        System.out.println("Stato iniziale:\n" + entita1 + "\n" + entita2);
        System.out.println("=========================================");
        
        // CREAZIONE DELLO SCANNER UNA SOLA VOLTA ALL'INIZIO
        Scanner scanner = new Scanner(System.in); 

        int turno = 1;
        
        try { // Uso del try/finally per garantire la chiusura
            while (entita1.isVivo() && entita2.isVivo()) {
                System.out.println("\n*** TURNO " + turno + " ***");

                // Giocatore (entita1) attacca Entità 2, passandogli lo scanner
                // Dobbiamo fare un cast sicuro a Giocatore se sappiamo che entita1 è sempre il giocatore
                if (entita1 instanceof Giocatore) {
                    ((Giocatore) entita1).turno(entita2, scanner);
                } else {
                    entita1.turno(entita2); // Se non fosse un giocatore, usa il turno automatico
                }

                if (!entita2.isVivo()) break; 

                // Turno del Mostro (entita2)
                entita2.turno(entita1);
                
                turno++;
            }
        } finally {
            // CHIUSURA DELLO SCANNER ALLA FINE DELLO SCONTRO
            scanner.close(); 
        }

        // Risultato finale (rimane invariato)
        System.out.println("\n=========================================");
        if (entita1.isVivo()) {
            System.out.println("VINCITORE: " + entita1.nome + ".");
        } else if (entita2.isVivo()) {
            System.out.println("VINCITORE: " + entita2.nome + ".");
        } else {
            System.out.println("Entrambi sconfitti. Doppio KO.");
        }
        System.out.println("=========================================");
    }
}