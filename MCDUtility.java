import java.util.*;

public class MCDUtility {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== Calcolatore MCD (Algoritmo di Euclide) ===");
        System.out.println("Inserisci due numeri interi (positivi o negativi).");
        
        System.out.print("Primo numero: ");
        int a = input.nextInt();

        System.out.print("Secondo numero: ");
        int b = input.nextInt();

        // Riordino automatico
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        System.out.println("\nValori riordinati:");
        System.out.println("a (maggiore) = " + a);
        System.out.println("b (minore)   = " + b);

        System.out.print("\nScegli modalità (1 = ricorsiva, 2 = iterativa): ");
        int sceltaMetodo = input.nextInt();
        boolean ricorsiva = (sceltaMetodo == 1);

        int risultato = mcdUnico(a, b, ricorsiva);

        System.out.println("\n>> RISULTATO:");
        System.out.println("Il Massimo Comune Divisore tra " + a + " e " + b + " è: " + risultato);

        System.out.println("\nProgramma terminato.");
        input.close();
    }

    // ----------------------------------------------------------
    // FUNZIONE UNICA MCD
    // ----------------------------------------------------------
    public static int mcdUnico(int a, int b, boolean ricorsivo) {

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 && b == 0) {
            System.out.println("Errore: il MCD non è definito quando entrambi i numeri sono 0.");
            return 0;
        }

        if (a == 0) return b;
        if (b == 0) return a;

        if (ricorsivo) {
            return mcdRic(a, b);
        } else {
            return mcdIter(a, b);
        }
    }

    // Funzione ricorsiva
    private static int mcdRic(int a, int b) {
        if (b == 0) return a;
        return mcdRic(b, a % b);
    }

    // Funzione iterativa
    private static int mcdIter(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }
}
