package es080126.es3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Persona> lista = new ArrayList<>();

        System.out.print("Quante persone vuoi inserire? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("È uno studente? (s/n): ");
            String scelta = sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Età: ");
            int eta = sc.nextInt();
            sc.nextLine();

            if (scelta.equalsIgnoreCase("s")) {
                System.out.print("Classe: ");
                String classe = sc.nextLine();
                lista.add(new Studente2(nome, eta, classe));
            } else {
                lista.add(new Persona(nome, eta));
            }
        }

        System.out.println("\n--- DESCRIZIONI ---");
        for (Persona p : lista) {
            p.descrizione(); // polimorfismo
        }

        sc.close();
    }
}

