package _34_es_05_03_2026;

import java.io.*;

public class Esercizio4 {
    public static void main(String[] args) {

        int count = 0;

        try (
            BufferedReader br = new BufferedReader(new FileReader("dati.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("risultato.txt"))
        ) {

            String riga;

            while ((riga = br.readLine()) != null) {

                if (riga.contains("2") || riga.contains("4")) {
                    bw.write(riga.toUpperCase());
                    bw.newLine();
                    count++;
                }

            }

            bw.write("Totale righe filtrate: " + count);

        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}