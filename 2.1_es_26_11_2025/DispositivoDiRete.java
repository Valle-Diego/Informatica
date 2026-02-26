package es261125;

import java.util.*;

public abstract class DispositivoDiRete implements Connettibile {

    protected String indirizzoIP;
    protected String nome;
    protected List<DispositivoDiRete> connessioni = new ArrayList<>();

    public DispositivoDiRete(String indirizzoIP, String nome) {
        this.indirizzoIP = indirizzoIP;
        this.nome = nome;
    }

    public String getIndirizzoIP() {
        return indirizzoIP;
    }

    public String getNome() {
        return nome;
    }

    // Metodo astratto → verrà implementato dalle sottoclassi
    public abstract void inviaDati(String dati, String destinazioneIP);

    public void connetti(DispositivoDiRete altroDispositivo) {
        if (!connessioni.contains(altroDispositivo)) {
            connessioni.add(altroDispositivo);
            altroDispositivo.connetti(this);  // Connessione bidirezionale
        }
    }

    public void disconnetti(DispositivoDiRete altroDispositivo) {
        connessioni.remove(altroDispositivo);
        altroDispositivo.connessioni.remove(this);
    }
}
