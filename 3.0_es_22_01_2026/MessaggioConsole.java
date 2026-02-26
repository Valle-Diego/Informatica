package es220126;

public class MessaggioConsole implements Messaggio {

    public void invia(String testo) {
        System.out.println("MESSAGGIO: " + testo);
    }
}
