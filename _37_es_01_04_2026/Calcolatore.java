package _37_es_01_04_2026;

class Calcolatore<T extends Number> {

    public double somma(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}