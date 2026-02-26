package es210126;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Ordine ordine = new Ordine();

        System.out.println("=== NEGOZIO TECH ===");

        // Creazione Smartphone
        System.out.println("\nInserisci dati Smartphone");
        System.out.print("Codice: ");
        String codSmart = scanner.nextLine();

        System.out.print("Nome: ");
        String nomeSmart = scanner.nextLine();

        System.out.print("Prezzo: ");
        double prezzoSmart = scanner.nextDouble();

        System.out.print("Memoria (GB): ");
        int memoria = scanner.nextInt();

        scanner.nextLine(); // pulizia buffer

        Prodotto smartphone = new Smartphone(
                codSmart, nomeSmart, prezzoSmart, memoria
        );

        // Creazione Laptop
        System.out.println("\nInserisci dati Laptop");
        System.out.print("Codice: ");
        String codLap = scanner.nextLine();

        System.out.print("Nome: ");
        String nomeLap = scanner.nextLine();

        System.out.print("Prezzo: ");
        double prezzoLap = scanner.nextDouble();

        System.out.print("Pollici: ");
        double pollici = scanner.nextDouble();

        scanner.nextLine(); // pulizia buffer

        Prodotto laptop = new Laptop(
                codLap, nomeLap, prezzoLap, pollici
        );

        // Quantità
        System.out.print("\nQuantità Smartphone: ");
        int qSmart = scanner.nextInt();

        System.out.print("Quantità Laptop: ");
        int qLap = scanner.nextInt();

        // Aggiunta all'ordine
        ordine.aggiungiProdotto(smartphone, qSmart);
        ordine.aggiungiProdotto(laptop, qLap);

        // Stampa ordine
        System.out.println("\n=== RIEPILOGO ORDINE ===");
        ordine.stampaOrdine();

        System.out.println("\nTotale ordine: €" + ordine.calcolaTotale());

        // Sconto (polimorfismo + interfaccia)
        if (smartphone instanceof Scontabile) {
            Scontabile s = (Scontabile) smartphone;
            System.out.println(
                "Prezzo smartphone scontato del 10%: " +
                s.prezzoScontato(10) + " euro"
            );
        }

        scanner.close();
    }
}
