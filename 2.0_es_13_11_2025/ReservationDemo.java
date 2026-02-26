package es131125;

public class ReservationDemo {
    public static void main(String[] args) {

        ReservationSystem sys = new ReservationSystem();

        // Creo alcuni voli
        Flight f1 = new Flight("AZ123", "Roma", "Parigi", 2);
        Flight f2 = new Flight("LH456", "Milano", "Berlino", 1);
        sys.addF(f1);
        sys.addF(f2);

        // Creo alcuni passeggeri
        Passenger p1 = new Passenger("Mario Rossi", "IT123456");
        Passenger p2 = new Passenger("Lucia Bianchi", "IT789012");

        // Prenotazioni Economy e Business
        Reservation r1 = new EconomyReservation("R001", p1, f1, true);
        Reservation r2 = new BusinessReservation("R002", p2, f1, false);
        Reservation r3 = new EconomyReservation("R003", p1, f2, false);

        sys.addRes(r1);
        sys.addRes(r2);
        sys.addRes(r3);

        sys.pF();

        // Confermo le prenotazioni
        System.out.println("\n--- CONFERME ---");
        r1.confirm();
        r2.confirm();
        r3.confirm(); // questo potrebbe fallire se i posti sono esauriti

        sys.pF();

        // Cancellazione
        System.out.println("\n--- CANCELLAZIONI ---");
        r1.canc();

        sys.pRes();
    }
}
