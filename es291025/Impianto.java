package es291025;

public class Impianto {
    private String n;
    private double Htar;

    public Impianto(String n, double Htar) {
        this.n = n;
        this.Htar = Htar;
    }

    public String getN() {
        return n;
    }

    public double getHtar() {
        return Htar;
    }

    public void setHtar(double Htar) {
        this.Htar = Htar;
    }

    public double GetPrice(int h) {
        return h * Htar;
    }

    public double GetPrice(int h, double dis) {
        double p = GetPrice(h);
        return p - (p * dis / 100);
    }

    public String toString() {
        return "Impianto: " + n + ", Tariffa oraria: " + Htar + " €/h";
    }
}

