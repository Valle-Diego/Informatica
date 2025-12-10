package es101225;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner sc = new Scanner(System.in);

        // Ordini di esempio
        Ordine o1 = new OrdineAsporto(PaymentMethod.CARD);
        o1.aggiungiItem(MenuItem.MARGHERITA, 2);
        o1.aggiungiItem(MenuItem.BIRRA, 1);
        manager.addOrdine(o1);

        Ordine o2 = new OrdineDomicilio(PaymentMethod.CASH, "Via Roma 10");
        o2.aggiungiItem(MenuItem.DIAVOLA, 1);
        o2.aggiungiItem(MenuItem.BEVANDA, 2);
        manager.addOrdine(o2);

        manager.stampaRiepilogo();

        // Inserimento console
        System.out.println("Vuoi inserire un nuovo ordine? (s/n)");
        String risp = sc.nextLine();
        if (!risp.equalsIgnoreCase("s")) {
            sc.close();
            return;
        }

        System.out.println("Tipo consegna (1=asporto, 2=domicilio):");
        int tipo = Integer.parseInt(sc.nextLine());
        Ordine nuovo;
        if (tipo == 1) nuovo = new OrdineAsporto(PaymentMethod.CASH);
        else {
            System.out.println("Inserisci indirizzo:");
            String indirizzo = sc.nextLine();
            nuovo = new OrdineDomicilio(PaymentMethod.CARD, indirizzo);
        }

        MenuItem[] prodotti = MenuItem.values();
        while (true) {
            System.out.println("\nProdotti disponibili:");
            for (int i = 0; i < prodotti.length; i++) {
                System.out.println((i+1) + ". " + prodotti[i].name() + " @ " + prodotti[i].getPrezzo());
            }
            System.out.println("Seleziona numero prodotto (0 per terminare):");
            int scelta = Integer.parseInt(sc.nextLine());
            if (scelta == 0) break;

            if (scelta < 1 || scelta > prodotti.length) {
                System.out.println("Scelta non valida, riprova.");
                continue;
            }

            MenuItem selezionato = prodotti[scelta - 1];
            System.out.println("Quantità:");
            int q = Integer.parseInt(sc.nextLine());
            nuovo.aggiungiItem(selezionato, q);
        }

        manager.addOrdine(nuovo);
        manager.stampaRiepilogo();
        sc.close();
    }
}
