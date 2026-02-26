package es26022026;

// Eccezione per errori nella prescrizione medica CHECKED
public class InvalidPrescriptionExc extends Exception {
    public InvalidPrescriptionExc(String reason) {
        super(reason);
    }

    public InvalidPrescriptionExc(String mess, Throwable cause) {
        super(mess, cause);
    }
}
