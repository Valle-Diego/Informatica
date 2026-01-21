package es111225;

public class ScrivaniaSingola implements Spazio {
    private String nome;

    public ScrivaniaSingola(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double calcolaCosto(int ore, boolean giornataIntera) {
        return giornataIntera ? 25.0 : ore * 5.0;
    }

    public boolean isDisponibile(java.util.List<Prenotazione> prenotazioni,
                                 int inizio, int fine) {
        for (Prenotazione p : prenotazioni) {
            if (p.getSpazio().getNome().equals(this.nome)) {
                if (p.siSovrappone(inizio, fine)) return false;
            }
        }
        return true;
    }
}
