package _33_es_26_02_2026;

//Eccezione per mancanze di permessi UNCHECKED
public class NoAuthorizationExc extends RuntimeException {
    private String doc;
    private String oper;

    public NoAuthorizationExc(String mess, String doc, String oper) {
        super(mess);
        this.doc = doc;
        this.oper = oper;
    }

    public NoAuthorizationExc(String mess, Throwable cause) {
        super(mess, cause);
    }
}
