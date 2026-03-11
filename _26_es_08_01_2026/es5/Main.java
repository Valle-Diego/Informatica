package _26_es_08_01_2026.es5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Età: ");
        int eta = sc.nextInt();
        sc.nextLine();

        System.out.print("Classe: ");
        String classe = sc.nextLine();

        Stampabile s = new StudenteStampabile(nome, eta, classe);
        s.stampa();

        sc.close();
    }
}
