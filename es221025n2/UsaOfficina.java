package es221025n2;

public class UsaOfficina {
    public static void main(String[] args) {
        Officina o = new Officina();

        Veicolo v1 = new Vettura("AA111AA", "Fiat", "500", "utilitaria");
        Veicolo v2 = new Motociclo("BB222BB", "Honda", "CBR", 125);
        Veicolo v3 = new Vettura("CC333CC", "BMW", "X3", "SUV");

        // Alcuni veicoli sono guasti
        v1.setBroke(true);
        v3.setBroke(true);

        System.out.println("=== Test Officina ===");
        System.out.println(v1 + " → Prezzo riparazione: " + o.rep(v1));
        System.out.println(v2 + " → Prezzo controllo: " + o.rep(v2));
        System.out.println(v3 + " → Prezzo riparazione: " + o.rep(v3));

        System.out.println("\nDopo la riparazione:");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}

