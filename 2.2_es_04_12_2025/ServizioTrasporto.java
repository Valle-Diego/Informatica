package es041225;

class ServizioTrasporto {
    private double d;
    private double pKm;

    public ServizioTrasporto(double d, double pKm) {
        this.d = d;
        this.pKm = pKm;
    }

    public double calcFinP(Tariffa t) {
        double bP = d * pKm;
        return t.calcP(bP);
    }
}