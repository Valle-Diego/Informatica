package es080126.es2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome studente: ");
        String nome = sc.nextLine();

        System.out.print("Età: ");
        int eta = sc.nextInt();
        sc.nextLine();

        System.out.print("Classe: ");
        String classe = sc.nextLine();

        Studente2 s = new Studente2(nome, eta, classe);
        s.descrizione();

        sc.close();
    }
}
