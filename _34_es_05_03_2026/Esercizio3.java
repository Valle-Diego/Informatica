package _34_es_05_03_2026;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

public class Esercizio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n1) Aggiungi nota");
            System.out.println("2) Leggi tutte le note");
            System.out.println("3) Esci");
            System.out.print("Scelta: ");

            scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {

                case 1:
                    System.out.print("Scrivi la nota: ");
                    String nota = sc.nextLine();

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("agenda.txt", true))) {
                        bw.write(LocalDateTime.now() + " - " + nota);
                        bw.newLine();
                    } catch (IOException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (BufferedReader br = new BufferedReader(new FileReader("agenda.txt"))) {

                        String riga;
                        while ((riga = br.readLine()) != null) {
                            System.out.println(riga);
                        }

                    } catch (IOException e) {
                        System.out.println("Nessuna nota trovata.");
                    }
                    break;

            }

        } while (scelta != 3);

        sc.close();
    }
}