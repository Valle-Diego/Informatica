import java.util.*;
import java.time.*;

public class Biblioteca {

    public enum Stato {
        ATTIVA,
        ANNULLATA,
        EVASA
    }

    private ArrayList<Prenotazione> prenotazioni;
    private int prossimoId;

    public Biblioteca() {
        prenotazioni = new ArrayList<>();
        prossimoId = 1;
    }

    public class Prenotazione {
        private int id;
        private String utente;
        private String isbn;
        private LocalDate data;
        private Stato stato;

        private Prenotazione(String utente, String isbn, LocalDate data) {
            this.id = prossimoId++;
            this.utente = utente;
            this.isbn = isbn;
            this.data = data;
            this.stato = Stato.ATTIVA;
        }
    }

    public int prenota(String utente, String isbn, LocalDate data) {
        Prenotazione p = new Prenotazione(utente, isbn, data);
        prenotazioni.add(p);
        return p.id;
    }

    public boolean annulla(int id) {
        for (Prenotazione p : prenotazioni) {
            if (p.id == id && p.stato == Stato.ATTIVA) {
                p.stato = Stato.ANNULLATA;
                return true;
            }
        }
        return false;
    }

    public boolean evadi(int id) {
        for (Prenotazione p : prenotazioni) {
            if (p.id == id && p.stato == Stato.ATTIVA) {
                p.stato = Stato.EVASA;
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> elencoAttivePerUtente(String utente) {
        ArrayList<String> risultato = new ArrayList<>();

        for (Prenotazione p : prenotazioni) {
            if (p.utente.equals(utente) && p.stato == Stato.ATTIVA) {
                risultato.add(p.isbn);
            }
        }

        return risultato;
    }
}
