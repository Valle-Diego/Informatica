package es080126.es4;

public class Quadrato extends Figura {
    double lato;

    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double area() {
        return lato * lato;
    }
}
