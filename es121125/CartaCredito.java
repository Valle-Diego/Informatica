package es121125;

public class CartaCredito extends Pagamento {
    private String numeroCarta;
    private String scadenza;
    private String cvv;

    public CartaCredito(double importo, String numeroCarta, String scadenza, String cvv) {
        super(importo);
        if (numeroCarta.length() != 16) {
            System.out.println("Numero carta non valido, impostato a 0000000000000000");
            this.numeroCarta = "0000000000000000";
        } else {
            this.numeroCarta = numeroCarta;
        }
        if (cvv.length() != 3) {
            System.out.println("CVV non valido, impostato a 000");
            this.cvv = "000";
        } else {
            this.cvv = cvv;
        }
        this.scadenza = scadenza;
    }

    public void paga() {
        System.out.println("Pagamento effettuato con carta di credito " + numeroCarta);
    }
}
