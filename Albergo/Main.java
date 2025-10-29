package Albergo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stanza[] stanze = new Stanza[99];
        for (int i = 0; i < 99; i++) {
            int numero = i + 1;
            double prezzo = 50 + i;
            stanze[i] = new Stanza(numero, prezzo);
        }

        Albergo albergo = new Albergo();

        int scelta;
        do {
            System.out.println("\n--- MENU ALBERGO ---");
            System.out.println("1. Aggiungi prenotazione");
            System.out.println("2. Visualizza prenotazioni");
            System.out.println("3. Visualizza stato stanze (tabella)");
            System.out.println("4. Effettua check-out (libera stanza)");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            scelta = sc.nextInt();
            sc.nextLine(); // consuma newline

            switch (scelta) {
                case 1: // Aggiungi prenotazione
                    System.out.print("Nome cliente: ");
                    String nome = sc.nextLine();

                    System.out.print("Numero notti: ");
                    int notti = sc.nextInt();

                    albergo.stampaStato(stanze);

                    System.out.print("\nScegli numero stanza: ");
                    int numStanza = sc.nextInt();

                    if (numStanza < 1 || numStanza > 99) {
                        System.out.println("Numero stanza non valido!");
                        break;
                    }

                    Stanza sceltaStanza = stanze[numStanza - 1];
                    albergo.addP(nome, notti, sceltaStanza);
                    break;

                case 2: // Visualizza prenotazioni
                    albergo.printP();
                    break;

                case 3: // Stato stanze
                    albergo.stampaStato(stanze);
                    break;

                case 4: // Check-out
                    System.out.print("Numero stanza da liberare: ");
                    int numCheckOut = sc.nextInt();
                    albergo.removeP(numCheckOut);
                    break;

                case 5: // Esci
                    System.out.println("Chiusura programma...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }

        } while (scelta != 5);

        sc.close();
    }
}
