package es121125;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portafoglio wallet = new Portafoglio(50);
        List<Pagamento> cronologia = new ArrayList<>();
        boolean continua = true;

        System.out.println("Benvenuto nel sistema di pagamento avanzato!");

        while (continua) {
            System.out.println("\nSeleziona il metodo di pagamento:");
            System.out.println("1. Carta di credito");
            System.out.println("2. PayPal");
            System.out.println("3. Abbonamento Premium");
            System.out.println("4. Mostra cronologia pagamenti");
            System.out.println("5. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // consuma invio

            if (scelta == 5) {
                continua = false;
                System.out.println("Uscita dal sistema. Grazie!");
                break;
            }

            if (scelta == 4) {
                if (cronologia.isEmpty()) {
                    System.out.println("Nessun pagamento effettuato.");
                } else {
                    System.out.println("Cronologia pagamenti:");
                    for (Pagamento p : cronologia) {
                        System.out.printf("- %.2feuro tramite %s\n", p.getImporto(), p.getClass().getSimpleName());
                    }
                }
                continue;
            }

            System.out.print("Inserisci l'importo: ");
            double importo = scanner.nextDouble();
            scanner.nextLine();

            Pagamento pagamento = null;

            if (scelta == 1) {
                System.out.print("Numero carta: ");
                String numeroCarta = scanner.nextLine();
                System.out.print("Scadenza (MM/AA): ");
                String scadenza = scanner.nextLine();
                System.out.print("CVV: ");
                String cvv = scanner.nextLine();
                pagamento = new CartaCredito(importo, numeroCarta, scadenza, cvv);

            } else if (scelta == 2) {
                System.out.print("Email PayPal: ");
                String email = scanner.nextLine();
                pagamento = new PayPal(importo, email);

            } else if (scelta == 3) {
                System.out.print("ID utente abbonamento: ");
                String idUtente = scanner.nextLine();
                pagamento = new AbbonamentoPremium(importo, idUtente);
            } else {
                System.out.println("Scelta non valida!");
                continue;
            }

            double sconto = wallet.applicaSconto(pagamento);

            pagamento.paga();
            pagamento.stampaRicevuta(sconto);
            System.out.printf("Saldo portafoglio: %.2feuro\n", wallet.getSaldo());

            cronologia.add(pagamento);
        }

        scanner.close();
    }
}
