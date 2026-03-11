package _35_es_11_03_2026;

public class Banca {
    private String nomeBanca;

    public Banca(String nome) {
        this.nomeBanca = nome;
    }

    public void stampaInfoBanca() {
        System.out.println("Banca: " + this.nomeBanca);
    }

    public ContoCorrente apriConto(String intestatario, double saldoIniziale) {
        return new ContoCorrente(intestatario, saldoIniziale);
    }

    public class ContoCorrente {
        private String intestatario;
        private double saldo;

        public ContoCorrente(String intestatario, double saldo) {
            this.intestatario = intestatario;
            this.saldo = saldo;
        }

        public void deposita(double importo) {
            this.saldo += importo;
        }

        public boolean preleva(double importo) {
            if (importo <= saldo) {
                this.saldo -= importo;
                return true;
            }
            return false;
        }

        public void stampaSaldo() {
            System.out.println(Banca.this.nomeBanca + " | " + intestatario + " | Saldo: " + saldo);
        }
    }

    public static class Statistiche {
        public static double calcolaMedia(double[] saldi) {
            double somma = 0;
            for (double s : saldi) somma += s;
            return saldi.length == 0 ? 0 : somma / saldi.length;
        }

        public static double trovaMassimo(double[] saldi) {
            double max = saldi.length > 0 ? saldi[0] : 0;
            for (double s : saldi) if (s > max) max = s;
            return max;
        }

        public static void stampaReport(double[] saldi) {
            System.out.println("=== Report Statistiche ===");
            System.out.printf("Media saldi: %.2f\n", calcolaMedia(saldi));
            System.out.printf("Saldo massimo: %.2f\n", trovaMassimo(saldi));
        }
    }
}