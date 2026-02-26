package es291025;

public class Calcetto extends Impianto {

    public Calcetto(String n, double Htar) {
        super(n, Htar);
    }

    public double GetPrice(int h) {
        double BaseCost = super.GetPrice(h);
        double LightsSup = 5.0 * h;
        return BaseCost + LightsSup;
    }
}

