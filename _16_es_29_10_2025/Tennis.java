package _16_es_29_10_2025;

public class Tennis extends Impianto {

    public Tennis(String n, double Htar) {
        super(n, Htar);
    }

    public double GetPrice(int h) {
        double BasePrice = super.GetPrice(h);
        return BasePrice * 0.9; // 10% di sconto
    }
}

