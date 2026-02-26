package es111225;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Coworking coworking = new Coworking();

        // Aggiungiamo alcuni spazi
        Spazio s1 = new ScrivaniaSingola("Scrivania A1");
        Spazio s2 = new SalaRiunioni("Sala Meeting");
        Spazio s3 = new UfficioPrivato("Ufficio 12");

        coworking.aggiungiSpazio(s1);
        coworking.aggiungiSpazio(s2);
        coworking.aggiungiSpazio(s3);

        int scelta = -1;

        while (scelta != 4) {
            System.out.println("\n===== MENU COWORKING =====");
            System.out.println("1) Elenco spazi");
            System.out.println("2) Effettua prenotazione");
            System.out.println("3) Mostra prenotazioni");
            System.out.println("4) Esci");
            System.out.print("Scegli: ");
            scelta = input.nextInt();

            if (scelta == 1) {
                System.out.println("\n--- SPAZI DISPONIBILI ---");
                System.out.println("1) " + s1.getNome());
                System.out.println("2) " + s2.getNome());
                System.out.println("3) " + s3.getNome());
            }

            else if (scelta == 2) {
                System.out.println("\nChe spazio vuoi prenotare?");
                System.out.println("1) " + s1.getNome());
                System.out.println("2) " + s2.getNome());
                System.out.println("3) " + s3.getNome());
                System.out.print("Scelta: ");
                int sp = input.nextInt();

                Spazio selezionato = null;

                if (sp == 1) {
                    selezionato = s1;
                } else if (sp == 2) {
                    selezionato = s2;
                } else if (sp == 3) {
                    selezionato = s3;
                } else {
                    System.out.println("Scelta non valida!");
                    continue;
                }

                System.out.print("Inserisci ora inizio (es. 9): ");
                int inizio = input.nextInt();
                System.out.print("Inserisci ora fine (es. 12): ");
                int fine = input.nextInt();

                boolean ok = coworking.prenota(selezionato, inizio, fine);

                if (ok == true) {
                    System.out.println("Prenotazione effettuata!");
                } else {
                    System.out.println("Impossibile prenotare: orario non disponibile!");
                }
            }

            else if (scelta == 3) {
                System.out.println("\n--- PRENOTAZIONI ---");
                coworking.mostraPrenotazioni();
            }

            else if (scelta == 4) {
                System.out.println("Uscita dal programma...");
            }

            else {
                System.out.println("Scelta non valida!");
            }
        }

        input.close();
    }
}
