package es221025n4;

import java.util.*;

public class QuesitoSiNo extends Quesito {

    public QuesitoSiNo(String q, String rr, int p) {
        super(q, rr, p);
    }

    public int ask() {
        Scanner x = new Scanner(System.in);
        String uA;

        // Accetta solo "si" o "no"
        do {
            System.out.println(q + " (rispondi si/no)");
            uA = x.nextLine().toLowerCase();
            x.close();
        } while (!uA.equals("si") && !uA.equals("no"));

        return uA.equalsIgnoreCase(rr) ? p : 0;
    }
}
