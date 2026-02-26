package es131125;

public class Passenger {
    private String n;
    private String pN;

    public Passenger(String n, String pN){
        this.n = n;
        this.pN = pN;
    }

    public String getN() {
        return n;
    }

    public String getPN() {
        return pN;
    }

    public String toString() {
        return n + " (Passaporto: " + pN + ")";
    }
}
