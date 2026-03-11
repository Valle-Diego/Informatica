package _33_es_26_02_2026;

// Eccezione per errori nella prescrizione medica CHECKED
public class InvalidPrescriptionExc extends Exception {
    public InvalidPrescriptionExc(String reason) {
        super(reason);
    }

    public InvalidPrescriptionExc(String mess, Throwable cause) {
        super(mess, cause);
    }
}
