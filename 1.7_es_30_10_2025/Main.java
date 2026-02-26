package es301025;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Inizializzare Scanner
        Scanner x = new Scanner(System.in);

        // Creare un nuovo oggetto Catalogo
        Catalogo c = new Catalogo();

        // Inizializzare la variabile Scelta
        int sc;

        // MENU DI SCELTA
        do {
            System.out.println("\n--- MENU LIBRERIA ---");
            System.out.println("  1. Aggiungi libro");
            System.out.println("  2. Aggiungi eBook");
            System.out.println("  3. Mostra catalogo");
            System.out.println("  4. Cerca per titolo");
            System.out.println("  5. Rimuovi libro");
            System.out.println("  6. Ordina per titolo");
            System.out.println("  7. Ordina per autore");
            System.out.println("  0. Esci");
            System.out.print("  : ");
            sc = x.nextInt();
            x.nextLine(); // Linea vuota

            // Switch case per la scelta
            switch (sc) {
                case 1:
                    // Aggiunta libri
                    System.out.print("Titolo: ");
                    String t = x.nextLine();
                    System.out.print("Autore: ");
                    String a = x.nextLine();
                    System.out.print("Anno di pubblicazione: ");
                    int y = x.nextInt();
                    x.nextLine();

                    Libro L = new Libro(t, a, y);
                    c.addL(L);
                    System.out.println("Libro aggiunto con successo!");
                    break;

                case 2:
                    // Aggiunta eBook
                    System.out.print("Titolo: ");
                    String te = x.nextLine();
                    System.out.print("Autore: ");
                    String ae = x.nextLine();
                    System.out.print("Anno di pubblicazione: ");
                    int ye = x.nextInt();
                    System.out.print("Dimensione file (MB): ");
                    double dF = x.nextDouble();
                    x.nextLine();

                    EBook e = new EBook(te, ae, ye, dF);
                    c.addL(e);
                    System.out.println("EBook aggiunto con successo!");
                    break;

                case 3:
                    // Mostra catalogo
                    c.showCat();
                    break;

                case 4:
                    // Cerca per titolo
                    System.out.print("Inserisci il titolo da cercare: ");
                    String cercaT = x.nextLine();
                    Libro found = c.searchxT(cercaT);
                    if (found != null)
                        System.out.println("Trovato: " + found);
                    else
                        System.out.println("Libro non trovato.");
                    break;

                case 5:
                    // Rimuovi libro
                    System.out.print("Inserisci il titolo da rimuovere: ");
                    String rimuoviT = x.nextLine();
                    if (c.removeL(rimuoviT))
                        System.out.println("Libro rimosso con successo!");
                    else
                        System.out.println("Libro non trovato.");
                    break;

                case 6:
                    // Ordina per titolo
                    c.sortxT();
                    break;

                case 7:
                    // Ordina per autore
                    c.sortxA();
                    break;

                case 0:
                    System.out.println("Chiusura programma...");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        } while (sc != 0);

        x.close();
    }
}
