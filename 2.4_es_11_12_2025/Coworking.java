package es111225;

import java.util.*;

public class Coworking {
    private List<Spazio> spazi = new ArrayList<>();
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    public void aggiungiSpazio(Spazio s) {
        spazi.add(s);
    }

    public boolean prenota(Spazio spazio, int inizio, int fine) {
        if (spazio.isDisponibile(prenotazioni, inizio, fine)) {
            prenotazioni.add(new Prenotazione(spazio, inizio, fine));
            return true;
        }
        return false;
    }

    public void mostraPrenotazioni() {
        for (Prenotazione p : prenotazioni) {
            System.out.println(p);
        }
    }
}

