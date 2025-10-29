package es221025n4;

import java.util.Scanner;

public class QuesitoNumerico extends Quesito {

    public QuesitoNumerico(String q, String rr, int p) {
        super(q, rr, p);
    }

    public int ask() {
        Scanner x = new Scanner(System.in);
        int uA = 0;
        boolean r = false;

        // Accetta solo un numero intero
        while (!r) {
            System.out.println(q + " (inserisci un numero intero)");
            try {
                uA = Integer.parseInt(x.nextLine());
                x.close();
                r = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero!");
            }
        }

        int corretta = Integer.parseInt(rr);
        return (uA == corretta) ? p : 0;
    }
}
