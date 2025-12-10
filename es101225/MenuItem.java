package es101225;

// Enum che rappresenta i prodotti del menu e il loro prezzo
public enum MenuItem {
    MARGHERITA(5.50),
    PROSCIUTTO(6.50),
    DIAVOLA(7.00),
    VEGETARIANA(6.80),
    QUATTRO_FORMAGGI(7.50),
    CAPRICCIOSA(7.80),
    NAPOLI(7.20),
    FRUTTI_DI_MARE(8.00),
    BIRRA(3.00),
    BEVANDA(1.50),
    ACQUA(1.00),
    VINO(4.50);

    private final double prezzo;

    MenuItem(double prezzo) {
        this.prezzo = prezzo;
    }

    // Restituisce il prezzo dell'item
    public double getPrezzo() {
        return prezzo;
    }
}
