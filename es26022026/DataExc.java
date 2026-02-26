package es26022026;

// Eccezione per dati anagrafici errati CHECKED

public class DataExc extends Exception {
    private String c;
    private Object val;

    public DataExc(String mess, String c, Object val) {
        super(mess);
        this.c = c;
        this.val = val;
    }

    public DataExc(String mess, Throwable cause) {
        super(mess, cause);
    }
}