package es26022026;

//Eccezione per saturazione posti letto UNCHECKED
public class FullExc extends RuntimeException {
    private String depName;

    public FullExc(String depName) {
        super("Nessun posto disponibile nel reparto: " + depName);
        this.depName = depName;
    }

    public FullExc(String mess, Throwable cause) {
        super(mess, cause);
    }
}
