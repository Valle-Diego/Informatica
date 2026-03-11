package _29_es_21_01_2026;

import java.util.*;

public class Ordine {

    public static class rigaOrdine {
        private Prodotto prodotto;
        private int quantita;

        public rigaOrdine(Prodotto prodotto, int quantita) {
            this.prodotto = prodotto;
            this.quantita = quantita;
        }

        public Prodotto getProdotto() {
            return prodotto;
        }

        public int getQuantita() {
            return quantita;
        }

        public double getSubTotale() {
            return prodotto.getPrezzo() * quantita;
        }

        public String toString() {
            return prodotto + " x " + quantita + " = " + getSubTotale() + " euro";
        }
    }
    private ArrayList<rigaOrdine> righe;

    public Ordine() {
        righe = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto p, int q) {
        if (q > 0) {
            righe.add(new rigaOrdine(p, q));
        } else {
            System.out.println("Quantità non valida, prodotto non aggiunto");
        }
    }

    public double calcolaTotale() {
        double totale = 0;
        for (rigaOrdine r : righe) {
            totale += r.getSubTotale();
        }
        return totale;
    }

    public void stampaOrdine() {
        for (rigaOrdine r : righe) {
            System.out.println(r);
        }
    }
}
