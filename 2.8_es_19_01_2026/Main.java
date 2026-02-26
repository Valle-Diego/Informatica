package es190126;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RegistroElettronico registro = new RegistroElettronico();
        registro.setListener(new NotaListener());

        System.out.print("Inserisci nome studente: ");
        String studente = scanner.nextLine();

        System.out.print("Inserisci testo della nota disciplinare: ");
        String nota = scanner.nextLine();

        registro.inserisciNota(studente, nota);

        scanner.close();
    }
}
