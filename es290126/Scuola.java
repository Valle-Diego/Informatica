package es290126;

public class Scuola {

    private String nome;
    private String indirizzo;

    public Scuola(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public void visualizzaScuola() {
        System.out.println("Scuola: " + nome);
        System.out.println("Indirizzo: " + indirizzo);
    }

    public Aula creaAula(int numeroAula, int numeroPosti) {
        return new Aula(numeroAula, numeroPosti);
    }

    public class Aula {

        private int numeroAula;
        private int numeroPosti;

        public Aula(int numeroAula, int numeroPosti) {
            this.numeroAula = numeroAula;
            this.numeroPosti = numeroPosti;
        }

        public void visualizzaAula() {
            System.out.println("Numero Aula: " + numeroAula);
            System.out.println("Numero Posti: " + numeroPosti);
            System.out.println("Appartiene alla scuola: " + nome);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {

        Scuola scuola = new Scuola("ITIS Galileo Galilei", "Via Roma 25");

        scuola.visualizzaScuola();
        System.out.println();

        Aula aula1 = scuola.creaAula(101, 25);
        Aula aula2 = scuola.creaAula(202, 30);

        aula1.visualizzaAula();
        aula2.visualizzaAula();
    }
}
