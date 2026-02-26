package GiocoFormica;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Inserisci il nome della formica: ");
        String nome = x.nextLine();
        System.out.print("Inserisci l'energia iniziale: ");
        int energia = x.nextInt();

        Formica f = new Formica(nome, energia);

        int scelta;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Muovi formica");
            System.out.println("2. Dai da mangiare");
            System.out.println("3. Mostra stato");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = x.nextInt();

            switch (scelta) {
                case 1 -> f.move();
                case 2 -> {
                    System.out.print("Quanta energia vuoi dare alla formica? ");
                    int food = x.nextInt();
                    f.eat(food);
                }
                case 3 -> System.out.println(f);
                case 0 -> System.out.println("Uscita dal programma...");
                default -> System.out.println("Scelta non valida!");
            }

        } while (scelta != 0);

        x.close();
    }
}