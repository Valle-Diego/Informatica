package es080126.es1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Età: ");
        int eta = sc.nextInt();

        Persona p = new Persona(nome, eta);
        p.descrizione();

        sc.close();
    }
}
