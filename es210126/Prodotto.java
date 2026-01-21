package es210126;

public abstract class Prodotto {
    private String codice;
    private String nome;
    private double prezzo;

    public Prodotto(String codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo > 0) {
            this.prezzo = prezzo;
        }
    }

    public abstract String getDescrizione();

    public String toString() {
        return codice + " - " + nome + " (" + prezzo + " euro )" ;
    }
}
