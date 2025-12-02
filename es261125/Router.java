package es261125;

public class Router extends DispositivoDiRete {

    public Router(String ip, String nome) {
        super(ip, nome);
    }

    public void inviaDati(String dati, String destinazioneIP) {
        System.out.println(nome + " (Router) instrada i dati verso " + destinazioneIP);

        for (DispositivoDiRete d : connessioni) {
            if (!d.getIndirizzoIP().equals(this.indirizzoIP)) {
                d.inviaDati(dati, destinazioneIP);
            }
        }
    }
}
