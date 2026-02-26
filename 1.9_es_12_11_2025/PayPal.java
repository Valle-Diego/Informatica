package es121125;

public class PayPal extends Pagamento {
    private String email;

    public PayPal(double importo, String email) {
        super(importo);
        if (email.indexOf("@") == -1) {
            System.out.println("Email non valida, impostata a default@email.com");
            this.email = "default@email.com";
        } else {
            this.email = email;
        }
    }

    public void paga() {
        System.out.println("Pagamento effettuato tramite PayPal (" + email + ")");
    }

    public double calcolaCommissione() {
        return importo * 0.03; // 3% di commissione
    }
}
