package es291025;

public class Tennis extends Impianto {

    public Tennis(String n, double Htar) {
        super(n, Htar);
    }

    public double GetPrice(int h) {
        double BasePrice = super.GetPrice(h);
        return BasePrice * 0.9; // 10% di sconto
    }
}

