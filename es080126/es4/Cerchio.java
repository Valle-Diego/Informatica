package es080126.es4;

public class Cerchio extends Figura {
    double r;

    public Cerchio(double r) {
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }
}

