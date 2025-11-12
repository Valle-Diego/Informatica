package es121125;

public abstract class Pagamento {
    protected double importo;

    public Pagamento(double importo) {
        if (importo <= 0) {
            System.out.println("Attenzione: l'importo deve essere maggiore di zero. Impostato a 1€.");
            this.importo = 1;
        } else {
            this.importo = importo;
        }
    }

    public abstract void paga();

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public double calcolaCommissione() {
        return 0;
    }

    public void stampaRicevuta(double sconto) {
        System.out.printf("Importo originale: %.2feuro\n", importo + sconto);
        System.out.printf("Sconto applicato: %.2feuro\n", sconto);
        System.out.printf("Importo finale: %.2feuro\n", importo);
        System.out.printf("Commissione: %.2feuro\n", calcolaCommissione());
    }
}
