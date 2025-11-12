package es121125;

public class Portafoglio {
    private double saldo;

    public Portafoglio(double saldo) {
        if (saldo < 0) saldo = 0;
        this.saldo = saldo;
    }

    public double applicaSconto(Pagamento pagamento) {
        double sconto = saldo;
        if (sconto > pagamento.getImporto()) {
            sconto = pagamento.getImporto();
        }
        pagamento.setImporto(pagamento.getImporto() - sconto);
        saldo -= sconto;
        return sconto;
    }

    public double getSaldo() {
        return saldo;
    }
}
