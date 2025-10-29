package es221025n4;

public class Test {
    public static void main(String[] args) {
        Quesito[] q = {
            new QuesitoSiNo("Il Sole è una stella?", "si", 2),
            new QuesitoNumerico("Quanto fa 5 + 3?", "8", 3),
            new QuesitoMultiplo("Qual è il numero atomico dell’ossigeno?\n1) 6\n2) 7\n3) 8\n4) 9", "3", 4, 4),
            new QuesitoSiNo("La Terra è piatta?", "no", 2),
            new QuesitoNumerico("Quanti giorni ha una settimana?", "7", 2)
        };

        int totP = 0;

        System.out.println("=== Inizio interrogazione ===");

        // Estrazione casuale di 3 quesiti usando Math.random()
        for (int i = 0; i < 3; i++) {
            int indice = (int) (Math.random() * q.length); // genera numero casuale da 0 a lunghezza-1
            totP += q[indice].ask();
        }

        System.out.println("=== Fine interrogazione ===");
        System.out.println("Punteggio totale: " + totP);
    }
}

