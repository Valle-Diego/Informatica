package es261125;

public class Switch extends DispositivoDiRete {

    public Switch(String ip, String nome) {
        super(ip, nome);
    }

    public void inviaDati(String dati, String destinazioneIP) {
        System.out.println(nome + " (Switch) inoltra i dati all'interno della rete");

        for (DispositivoDiRete d : connessioni) {
            if (!(d instanceof Switch)) {  
                d.inviaDati(dati, destinazioneIP);
            }
        }
    }
}
