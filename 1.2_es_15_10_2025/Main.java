package Tris;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tris gioco = new Tris();

        System.out.println("=== Benvenuto nel gioco del Tris ===");
        System.out.println("Le coordinate vanno da 1 a 3 (esempio: riga=2, colonna=3)\n");

        // Scelta del simbolo per il giocatore 1
        System.out.print("Giocatore 1, scegli il tuo simbolo (X o O): ");
        char simbolo = Character.toUpperCase(sc.next().charAt(0));
        while (simbolo != 'X' && simbolo != 'O') {
            System.out.print("Simbolo non valido! Scegli 'X' o 'O': ");
            simbolo = Character.toUpperCase(sc.next().charAt(0));
        }

        gioco.setS(simbolo);

        System.out.println("\nGiocatore 1 usa '" + simbolo + "', Giocatore 2 usa '" +
                ((simbolo == 'X') ? 'O' : 'X') + "'.");
        System.out.println();
        gioco.PrintM();

        // Ciclo principale del gioco
        while (true) {
            int giocatore = gioco.getG1() ? 1 : 2;
            char s = gioco.getS();

            System.out.println("\nTurno del Giocatore " + giocatore + " (" + s + ")");
            System.out.print("Inserisci riga (1-3): ");
            int riga = sc.nextInt();
            System.out.print("Inserisci colonna (1-3): ");
            int colonna = sc.nextInt();

            if (gioco.Move(riga, colonna)) {
                gioco.PrintM();

                if (gioco.controlWin(s)) {
                    System.out.println("\n🎉 Il Giocatore " + giocatore + " (" + s + ") ha vinto!");
                    break;
                } else if (gioco.FullGrid()) {
                    System.out.println("\n🤝 Pareggio! Nessun vincitore.");
                    break;
                }

                gioco.SwTurn(); // passa il turno
            }
        }

        sc.close();
    }
}
