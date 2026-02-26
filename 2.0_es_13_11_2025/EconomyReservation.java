package es131125;

public class EconomyReservation extends Reservation {
    private boolean exB;

    public EconomyReservation(String id, Passenger p, Flight f, boolean exB) {
        super(id, p, f);
        this.exB = exB;
    }

    public double calcP() {
        double b = 100.0;
        if (exB) b += 30.0;
        return b;
    }

    public void onConf() {
        System.out.println("Prenotazione Economy confermata. " +
                (exB ? "Bagaglio extra incluso." : "Nessun bagaglio extra."));
    }

    public void onCanc() {
        System.out.println("❌ Prenotazione Economy annullata. Rimborso parziale del 50%.");
    }
}
