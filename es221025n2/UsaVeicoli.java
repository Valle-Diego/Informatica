package es221025n2;

public class UsaVeicoli {
    public static void main(String[] args) {
        // Creiamo un array di veicoli
        Veicolo[] veicoli = {
            new Vettura("AB123CD", "Fiat", "Panda", "utilitaria"),
            new Vettura("EF456GH", "Audi", "Q5", "SUV"),
            new Motociclo("IJ789KL", "Yamaha", "R125", 125),
            new Motociclo("MN012OP", "Piaggio", "Liberty", 50)
        };

        // Alcuni veicoli diventano guasti
        veicoli[1].setBroke(true);
        veicoli[3].setBroke(true);

        System.out.println("=== Veicoli guasti ===");
        for (Veicolo v : veicoli) {
            if (v.isBroke()) {
                System.out.println(v.getT());
            }
        }
    }
}
