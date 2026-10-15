// File: TrenoAltaVelocita.java
public class TrenoAltaVelocita extends Treno {

    private int velocitaMaxKmh;  // es. 300
    private double prezzoPerKm;  // es. 0.35 euro/km

    // Il costruttore chiama prima il costruttore di Treno (super)
    public TrenoAltaVelocita(String codice, String destinazione,
                              int posti, int velocitaMax, double prezzoKm) {
        super(codice, destinazione, posti); // costruisce la parte 'Treno'
        this.velocitaMaxKmh = velocitaMax;
        this.prezzoPerKm = prezzoKm;
    }

    public int getVelocitaMax() { return velocitaMaxKmh; }
    public double getPrezzoPerKm() { return prezzoPerKm; }

    // Calcola il prezzo totale per una tratta di 'km' chilometri
    public double calcolaPrezzo(int km) {
        return km * prezzoPerKm;
    }

    // Override: modifica stampaInfo() aggiungendo la velocita'
    @Override
    public void stampaInfo() {
        super.stampaInfo(); // stampa le info base di Treno
        System.out.println("  Velocita' max: " + velocitaMaxKmh + " km/h");
        System.out.println("  Prezzo/km    : " + prezzoPerKm + " euro");
    }
}
