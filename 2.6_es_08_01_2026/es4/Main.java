package es080126.es4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Scegli figura (1=Quadrato, 2=Cerchio): ");
        int scelta = sc.nextInt();

        Figura f;

        if (scelta == 1) {
            System.out.print("Lato: ");
            double lato = sc.nextDouble();
            f = new Quadrato(lato);
        } else {
            System.out.print("Raggio: ");
            double r = sc.nextDouble();
            f = new Cerchio(r);
        }

        System.out.println("Area = " + f.area());

        sc.close();
    }
}
