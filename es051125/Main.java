package es051125;

import java.util.Scanner;

// Classe principale con il menu
public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in); // input da tastiera
        Videoteca v = new Videoteca();      // oggetto videoteca
        int scelta;                         // variabile per la scelta menu

        do {
            // Menu testuale
            System.out.println("\n■ MENU VIDEOTECA ■");
            System.out.println("1. Aggiungi film");
            System.out.println("2. Mostra tutti");
            System.out.println("3. Cerca film");
            System.out.println("4. Rimuovi film");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = x.nextInt();
            x.nextLine(); // pulisce il buffer

            switch (scelta) {
                case 1: // aggiungi film
                    System.out.print("Titolo: ");
                    String t = x.nextLine();
                    System.out.print("Regista: ");
                    String r = x.nextLine();
                    System.out.print("Anno: ");
                    int a = x.nextInt();
                    x.nextLine();

                    Film f = new Film(t, r, a);
                    v.addF(f);
                    break;

                case 2: // mostra tutti
                    v.showF();
                    break;

                case 3: // cerca film
                    System.out.print("Titolo da cercare: ");
                    String tc = x.nextLine();
                    Film trovato = v.searchF(tc);
                    if (trovato != null)
                        System.out.println(" Trovato: " + trovato);
                    else
                        System.out.println(" Nessun film trovato.");
                    break;

                case 4: // rimuovi film
                    System.out.print("Titolo da rimuovere: ");
                    String tr = x.nextLine();
                    if (v.removeF(tr))
                        System.out.println(" Film rimosso!");
                    else
                        System.out.println(" Film non trovato.");
                    break;

                case 0: // esci
                    System.out.println(" Uscita...");
                    break;

                default:
                    System.out.println(" Scelta non valida!");
            }

        } while (scelta != 0);

        x.close();
    }
}
