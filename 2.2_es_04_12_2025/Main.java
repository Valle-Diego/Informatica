package es041225;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Inserisci distanza (km): ");
        double d = x.nextDouble();

        System.out.print("Inserisci costo per km: ");
        double pKm = x.nextDouble();

        System.out.println("\nScegli la tariffa: BASE, PREMIUM, BUSINESS, VIP");
        System.out.print("Tariffa: ");
        String tarT = x.next().toUpperCase();

        Tariffa tarC;
        try {
            tarC = Tariffa.valueOf(tarT);
        } catch (IllegalArgumentException e) {
            System.out.println("Tariffa non valida. Uso BASE.");
            tarC = Tariffa.BASE;
        }

        ServizioTrasporto s = new ServizioTrasporto(d, pKm);
        double finP = s.calcFinP(tarC);

        System.out.println("\n--- RISULTATO ---");
        System.out.println("Tariffa: " + tarC);
        System.out.println(tarC.getD());
        System.out.printf("Costo totale: %.2f €\n", finP);

        x.close();
    }
}
