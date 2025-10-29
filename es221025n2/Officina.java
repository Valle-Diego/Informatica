package es221025n2;

public class Officina {

    public double rep(Veicolo v) {
        double prezzo;

        // Prezzo diverso a seconda del tipo di veicolo e se è guasto
        if (v instanceof Vettura) {
            prezzo = v.isBroke() ? 200.0 : 50.0;
        } else if (v instanceof Motociclo) {
            prezzo = v.isBroke() ? 100.0 : 30.0;
        } else {
            prezzo = 0.0; // tipo sconosciuto
        }

        // Se era guasto, lo ripariamo
        if (v.isBroke()) {
            v.setBroke(false);
        }

        return prezzo;
    }
}

