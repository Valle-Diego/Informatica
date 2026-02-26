package es291025;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.println("=== SISTEMA DI PRENOTAZIONE IMPIANTO SPORTIVO ===");
        System.out.println("Scegli il tipo di impianto:");
        System.out.println("1. Campo da Calcetto");
        System.out.println("2. Campo da Tennis");
        System.out.println("3. Piscina");
        System.out.print("Scelta: ");
        int sc = x.nextInt();

        x.nextLine();

        System.out.print("Inserisci il nome dell'impianto: ");
        String n = x.nextLine();

        System.out.print("Inserisci la tariffa oraria (€): ");
        double Htar = x.nextDouble();

        System.out.print("Inserisci il numero di ore da prenotare: ");
        int h = x.nextInt();

        System.out.print("Hai un coupon sconto? (s/n): ");
        char ans = x.next().toLowerCase().charAt(0);

        double dis = 0.0;
        if (ans == 's') {
            System.out.print("Inserisci la percentuale di sconto: ");
            dis = x.nextDouble();
        }

        Impianto imp;
        switch (sc) {
            case 1 -> imp = new Calcetto(n, Htar);
            case 2 -> imp = new Tennis(n, Htar);
            case 3 -> imp = new Piscina(n, Htar);
            default -> {
                System.out.println("Scelta non valida.");
                x.close();
                return;
            }
        }

        double pr = (dis > 0)
                ? imp.GetPrice(h, dis)
                : imp.GetPrice(h);

        System.out.println("\n--- RIEPILOGO PRENOTAZIONE ---");
        System.out.println(imp);
        System.out.println("Ore prenotate: " + h);
        System.out.println("Sconto applicato: " + dis + "%");
        System.out.println("Costo totale: " + pr + " €");

        x.close();
    }
}
