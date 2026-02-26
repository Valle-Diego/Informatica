package es26022026;

// Eccezione per parametri vitali fuori soglia CHECKED
public class LifeParamExc extends Exception {
    private String param;
    private double val, min, max;

    public LifeParamExc(String mess, String param, double val, double min, double max) {
        super(mess);
        this.param = param;
        this.val = val;
        this.min = min;
        this.max = max;
    }

    public LifeParamExc(String mess, Throwable cause) {
        super(mess, cause);
    }

    // Determina se il valore è in range di emergenza
    public boolean isEmergency() {
        return val < (min - 5) || val > (max + 5);
    }
}
