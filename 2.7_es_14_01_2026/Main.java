import java.time.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1 - Prenota libro");
            System.out.println("2 - Annulla prenotazione");
            System.out.println("3 - Evadi prenotazione");
            System.out.println("4 - Elenco prenotazioni attive per utente");
            System.out.println("0 - Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 1:
                    System.out.print("Nome utente: ");
                    String utente = scanner.nextLine();

                    System.out.print("ISBN libro: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Data (YYYY-MM-DD): ");
                    LocalDate data = LocalDate.parse(scanner.nextLine());

                    int id = biblioteca.prenota(utente, isbn, data);
                    System.out.println("Prenotazione creata con ID: " + id);
                    break;

                case 2:
                    System.out.print("ID prenotazione da annullare: ");
                    int idAnnulla = scanner.nextInt();

                    if (biblioteca.annulla(idAnnulla)) {
                        System.out.println("Prenotazione annullata.");
                    } else {
                        System.out.println("Impossibile annullare la prenotazione.");
                    }
                    break;

                case 3:
                    System.out.print("ID prenotazione da evadere: ");
                    int idEvadi = scanner.nextInt();

                    if (biblioteca.evadi(idEvadi)) {
                        System.out.println("Prenotazione evasa.");
                    } else {
                        System.out.println("Impossibile evadere la prenotazione.");
                    }
                    break;

                case 4:
                    System.out.print("Nome utente: ");
                    String nomeUtente = scanner.nextLine();

                    ArrayList<String> attive = biblioteca.elencoAttivePerUtente(nomeUtente);

                    if (attive.isEmpty()) {
                        System.out.println("Nessuna prenotazione attiva.");
                    } else {
                        System.out.println("ISBN prenotazioni attive:");
                        for (String codice : attive) {
                            System.out.println("- " + codice);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }
}
