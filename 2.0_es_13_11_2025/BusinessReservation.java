package es131125;

public class BusinessReservation extends Reservation {
    private boolean louA;

    public BusinessReservation(String id, Passenger p, Flight f, boolean louA) {
        super(id, p, f);
        this.louA = louA;
    }

    public double calcP() {
        double base = 250.0;
        if (louA) base += 50.0;
        return base;
    }

    public void onConf() {
        System.out.println("Prenotazione Business confermata. " +
                (louA ? "Accesso lounge incluso." : "Nessun accesso lounge."));
    }

    public void onCanc() {
        System.out.println("Prenotazione Business annullata. Rimborso completo previsto.");
    }
}