package es261125;

public class Computer extends DispositivoDiRete {

    public Computer(String ip, String nome) {
        super(ip, nome);
    }

    public void inviaDati(String dati, String destinazioneIP) {
        System.out.println(nome + " invia dati verso " + destinazioneIP + ": \"" + dati + "\"");

        for (DispositivoDiRete d : connessioni) {
            d.inviaDati(dati, destinazioneIP);
        }
    }

    public void riceviDati(String dati) {
        System.out.println(nome + " ha ricevuto i dati: \"" + dati + "\"");
    }
}
