package _34_es_05_03_2026;

import java.io.*;

public class Esercizio2 {
    public static void main(String[] args) {

        int contatore = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("dati.txt"))) {

            String riga;

            while ((riga = br.readLine()) != null) {
                contatore++;
                System.out.println(contatore + ": " + riga);
            }

            System.out.println("Totale righe: " + contatore);

        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}