// File: Treno.java
public class Treno {

    // ATTRIBUTI: le informazioni che ogni treno possiede
    private String codice;       // es. "FR9600"
    private String destinazione; // es. "Roma"
    private int postiTotali;     // quanti posti ha il treno
    private int postiOccupati;   // quanti posti sono gia' presi
    private boolean inRitardo;   // true se il treno e' in ritardo

    // COSTRUTTORE: viene chiamato quando creiamo un nuovo treno
    public Treno(String codice, String destinazione, int postiTotali) {
        this.codice = codice;
        this.destinazione = destinazione;
        this.postiTotali = postiTotali;
        this.postiOccupati = 0;    // all'inizio nessun posto occupato
        this.inRitardo = false;    // all'inizio in orario
    }

    // METODI: le azioni che un treno sa fare

    // Restituisce il codice del treno
    public String getCodice() {
        return codice;
    }

    // Restituisce la destinazione
    public String getDestinazione() {
        return destinazione;
    }

    // Calcola i posti ancora liberi
    public int getPostiLiberi() {
        return postiTotali - postiOccupati;
    }

    // Prende un posto se disponibile; ritorna true se ha avuto successo
    public boolean prenota() {
        if (postiOccupati < postiTotali) {
            postiOccupati++;
            return true; // prenotazione riuscita
        }
        return false; // treno pieno
    }

    // Segna il treno come in ritardo
    public void segnalaRitardo() {
        this.inRitardo = true;
    }

    // Getter per lo stato di ritardo (necessario per Stazione) -- Esercizio 4
    public boolean isInRitardo() {
        return inRitardo;
    }

    // Ritorna true se il treno e' occupato all'80% o piu' -- Esercizio 3
    public boolean isSaturo() {
        if (postiOccupati >= postiTotali * 0.80) {
            return true;
        }
        return false;
    }

    // Stampa le informazioni del treno in modo leggibile
    public void stampaInfo() {
        System.out.println("Treno: " + codice);
        System.out.println("  Destinazione : " + destinazione);
        System.out.println("  Posti liberi : " + getPostiLiberi()
                + "/" + postiTotali);
        System.out.println("  Stato        : "
                + (inRitardo ? "IN RITARDO" : "in orario"));
    }
}
