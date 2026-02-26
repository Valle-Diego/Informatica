package es221025n1;

public class UsaDipendente {
    public static void main(String[] args) {
        Dipendente d1 = new Dipendente("RSSMRA80A01H501Z", "Mario", "Rossi", 2015, 1800);
        Dipendente d2 = new Dipendente("BNCLCU75B22H501A", "Luca", "Bianchi", 2010, 2000);
        Dipendente d3 = new Dipendente("VRDNNA90C10H501B", "Anna", "Verdi", 2018, 1700);

        Dipendente[] elenco = { d1, d2, d3 };

        // Ordinamento per stipendio decrescente (dal più alto al più basso)
        for (int i = 0; i < elenco.length - 1; i++) {
            for (int j = i + 1; j < elenco.length; j++) {
                if (!elenco[i].gPiuDi(elenco[j])) {
                    Dipendente temp = elenco[i];
                    elenco[i] = elenco[j];
                    elenco[j] = temp;
                }
            }
        }

        System.out.println("Dipendenti in ordine di stipendio:");
        for (Dipendente d : elenco) {
            System.out.println(d);
        }
    }
}
