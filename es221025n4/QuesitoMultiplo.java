package es221025n4;

import java.util.Scanner;

public class QuesitoMultiplo extends QuesitoNumerico {
    private int numOpz;

    public QuesitoMultiplo(String q, String rr, int p, int numOpz) {
        super(q, rr, p);
        this.numOpz = numOpz;
    }

    public int ask() {
        Scanner x = new Scanner(System.in);
        int a = 0;
        boolean r = false;

        // Accetta solo numeri interi validi tra 1 e numOpzioni
        while (!r) {
            System.out.println(q + " (scegli un numero tra 1 e " + numOpz + ")");
            try {
                a = Integer.parseInt(x.nextLine());
                x.close();
                if (a >= 1 && a <= numOpz) {
                    r = true;
                } else {
                    System.out.println("Errore: il numero deve essere tra 1 e " + numOpz);
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero!");
            }
        }

        int t = Integer.parseInt(rr);
        return (a == t) ? p : 0;
    }
}
