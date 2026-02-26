package es220126;

public class Centralina {

    private String nome;

    public Centralina(String nome) {
        this.nome = nome;
    }

    // A) Static Nested Class
    public static class Logger {

        public static void log(String testo) {
            System.out.println("[LOG] " + testo);
        }
    }

    // B) Inner Class (non static)
    public class Sensore {

        private int valore;

        public void aggiorna(int v) {
            valore = v;
            System.out.println("Centralina " + nome + " - valore sensore: " + valore);
        }

        public int getValore() {
            return valore;
        }
    }
}
