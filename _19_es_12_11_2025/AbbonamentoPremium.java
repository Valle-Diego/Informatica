package _19_es_12_11_2025;

public class AbbonamentoPremium extends Pagamento {
    private String idUtente;

    public AbbonamentoPremium(double importo, String idUtente) {
        super(importo);
        this.idUtente = idUtente;
    }

    public void paga() {
        System.out.println("Abbonamento premium rinnovato per utente " + idUtente);
    }
}

