package es221025n4;

import java.util.*;

public class Quesito {
    protected String q;
    protected String rr;
    protected int p;

    public Quesito(String q, String rr, int p) {
        this.q = q;
        this.rr = rr;
        this.p = p;
    }

    // Metodo ask(): fa la domanda e valuta la risposta
    public int ask() {
        Scanner x = new Scanner(System.in);
        System.out.println(q);
        String uA = x.nextLine();
        x.close();

        if (uA.equalsIgnoreCase(rr)) {
            return p;
        } else {
            return 0;
        }
        
    }
    
}
