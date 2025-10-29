package Albergo;

import java.util.ArrayList;

public class Albergo {
    private ArrayList<Prenotazione> prenotazioni;

    public Albergo() {
        prenotazioni = new ArrayList<>();
    }

    // Aggiungi prenotazione
    public void addP(String cliente, int notti, Stanza stanza) {
        if (stanza.isOccupata()) {
            System.out.println("❌ La stanza " + stanza.getNStanza() + " è già occupata!");
            return;
        }
        Prenotazione p = new Prenotazione(cliente, notti, stanza);
        prenotazioni.add(p);
        System.out.println("Prenotazione aggiunta per " + cliente +
                   " nella stanza " + stanza.getNStanza());
    }

    // Stampa prenotazioni
    public void printP() {
        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione presente.");
        } else {
            System.out.println("\n--- Elenco Prenotazioni ---");
            for (Prenotazione p : prenotazioni) {
                System.out.println(p);
            }
        }
    }

    // Rimuovi prenotazione (check-out)
    public void removeP(int nStanza) {
        for (int i = 0; i < prenotazioni.size(); i++) {
            Prenotazione p = prenotazioni.get(i);
            if (p.getStanza().getNStanza() == nStanza) {
                p.getStanza().setOccupata(false); // libera la stanza
                prenotazioni.remove(i);
                System.out.println("Stanza " + nStanza + " liberata.");
                return;
            }
        }
        System.out.println("Nessuna prenotazione trovata per la stanza " + nStanza);
    }

        public void stampaStato(Stanza[] stanze) {
        System.out.println("\n--- Stato Stanze ---");
        // Intestazione
        System.out.printf("| %-6s | %-6s |    %-5s   | %-6s | %-6s |    %-5s   | %-6s | %-6s |    %-5s   |%n",
                        "Stanza", "Prezzo", "Stato",
                        "Stanza", "Prezzo", "Stato",
                        "Stanza", "Prezzo", "Stato");
        System.out.println("|--------|--------|------------|--------|--------|------------|--------|--------|------------|");

        for (int i = 0; i < stanze.length; i += 3) {
            Stanza s1 = stanze[i];
            String stato1 = s1.isOccupata() ? "[X] Occupata" : "[ ] Libera";

            Stanza s2 = (i + 1 < stanze.length) ? stanze[i + 1] : null;
            String stato2 = (s2 != null && s2.isOccupata()) ? "[X] Occupata" : "[ ] Libera";

            Stanza s3 = (i + 2 < stanze.length) ? stanze[i + 2] : null;
            String stato3 = (s3 != null && s3.isOccupata()) ? "[X] Occupata" : "[ ] Libera";

            // Stampa le tre stanze affiancate
            System.out.printf("| %-6s | %-6s | %-5s |",
                            s1.getNStanza(), s1.getPBase(), stato1);

            if (s2 != null)
                System.out.printf(" %-6s | %-6s | %-5s |",
                                s2.getNStanza(), s2.getPBase(), stato2);
            else
                System.out.printf("%-29s", ""); // spazio se non c'è seconda stanza

            if (s3 != null)
                System.out.printf(" %-6s | %-6s | %-5s |%n",
                                s3.getNStanza(), s3.getPBase(), stato3);
            else
                System.out.printf("%n"); // a capo se non c'è terza stanza
        }
    }
}
