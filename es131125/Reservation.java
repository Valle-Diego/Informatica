package es131125;

import java.time.*;

public abstract class Reservation {
    protected String id;
    protected Passenger p;
    protected Flight f;
    protected boolean conf;
    protected LocalDate cD;

    public Reservation(String id, Passenger p, Flight f) {
        this.id = id;
        this.p = p;
        this.f = f;
        this.conf= false;
        this.cD = LocalDate.now();
    }

    public abstract double calcP();

    public abstract void onConf();

    public abstract void onCanc();

    // Metodo concreto per confermare una prenotazione
    public void confirm() {
        if (!f.avS()) {
            System.out.println("Nessun posto disponibile per il volo " + f.getC());
            return;
        }

        if (conf) {
            System.out.println("Prenotazione già confermata.");
            return;
        }

        // Simula pagamento
        System.out.println("Elaborazione pagamento di " + calcP() + " euro...");
        conf = f.bookAS();

        if (conf) {
            onConf();
            System.out.println("Prenotazione confermata per " + p.getN() + " sul volo " + f.getC());
        } else {
            System.out.println("Impossibile confermare la prenotazione.");
        }
    }

    // Metodo concreto per annullare una prenotazione
    public void canc() {
        if (!conf) {
            System.out.println("Prenotazione non ancora confermata, nessuna cancellazione necessaria.");
            return;
        }

        conf = false;
        f.canS();
        onCanc();
        System.out.println("Prenotazione " + id + " annullata con successo.");
    }

    public String getId() {
        return id;
    }

    public Passenger getP() {
        return p;
    }

    public Flight getF() {
        return f;
    }

    public boolean isConf() {
        return conf;
    }

    public String toString() {
        return "Prenotazione " + id + " | " + p.getN() + " | Volo " +
               f.getC() + " | Stato: " + (conf ? "Confermata" : "In attesa");
    }
}
