package es041225;

enum Tariffa {
    BASE("Tariffa base: nessun sovrapprezzo"),
    PREMIUM("Tariffa premium: +10%"),
    BUSINESS("Tariffa business: +25%"),
    VIP("Tariffa VIP: +50%");

    private String d;

    Tariffa(String d) {
        this.d = d;
    }

    public String getD() {
        return d;
    }

    public double calcP(double bP) {
        switch (this) {
            case BASE:
                return bP;
            case PREMIUM:
                return bP * 1.10;
            case BUSINESS:
                return bP * 1.25;
            case VIP:
                return bP * 1.50;
            default:
                return bP;
        }
    }
}