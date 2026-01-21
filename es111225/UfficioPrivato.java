package es111225;

public class UfficioPrivato implements Spazio {
    private String nome;

    public UfficioPrivato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double calcolaCosto(int ore, boolean giornataIntera) {
        return giornataIntera ? 90.0 : ore * 15.0;
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
