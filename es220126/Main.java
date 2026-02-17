package es220126;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Centralina
        System.out.print("Inserisci nome della centralina: ");
        String nomeCentralina = scanner.nextLine();
        Centralina centralina = new Centralina(nomeCentralina);

        // 2. Log di avvio
        Centralina.Logger.log("Avvio sistema");

        // 3. Creazione sensore (inner class)
        Centralina.Sensore s = centralina.new Sensore();

        // 4. Primo valore
        System.out.print("Inserisci primo valore del sensore: ");
        int v1 = scanner.nextInt();
        s.aggiorna(v1);

        // 5. Secondo valore
        System.out.print("Inserisci secondo valore del sensore: ");
        int v2 = scanner.nextInt();
        s.aggiorna(v2);

        // 6. Controllo soglia
        if (s.getValore() > 50) {
            Messaggio m = new MessaggioConsole();
            m.invia("ALLARME: valore alto");
        }

        scanner.close();
    }
}
