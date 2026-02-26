package es261125;

public class Main {
    public static void main(String[] args) {

        Computer pc1 = new Computer("192.168.1.10", "PC1");
        Computer pc2 = new Computer("192.168.1.20", "PC2");
        Switch sw = new Switch("192.168.1.1", "Switch1");
        Router router = new Router("10.0.0.1", "Router1");

        // Creazione rete
        pc1.connetti(sw);
        pc2.connetti(sw);
        sw.connetti(router);

        // Invio dati
        pc1.inviaDati("Ciao PC2!", "192.168.1.20");
    }
}
