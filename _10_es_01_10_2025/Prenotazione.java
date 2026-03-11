package _10_es_01_10_2025;

public class Prenotazione {
    private String cliente;
    private int notti;
    private Stanza stanza;

    public Prenotazione(String cliente, int notti, Stanza stanza) {
        this.cliente = cliente;
        this.notti = notti;
        this.stanza = stanza;
        stanza.setOccupata(true); // appena prenoto → la stanza diventa occupata
    }

    public double getTotale() {
        return notti * stanza.getPBase();
    }

    public Stanza getStanza() {
        return stanza;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente +
               " | Notti: " + notti +
               " | " + stanza +
               " | Totale: " + getTotale() + " euro";
    }
}