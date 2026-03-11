package _34_es_05_03_2026;

import java.io.*;

public class Esercizio1 {
    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dati.txt"))) {

            for (int i = 1; i <= 5; i++) {
                bw.write("Riga " + i);
                bw.newLine();
            }

            System.out.println("File scritto con successo!");

        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}