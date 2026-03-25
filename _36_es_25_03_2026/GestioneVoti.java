package _36_es_25_03_2026;

import java.io.*;
import java.util.*;

public class GestioneVoti {

    static class FileManager {

        public static ArrayList<Double> leggiFile(String n)
                throws IOException {
 
            ArrayList<Double> grades = new ArrayList<>();
 
            try (BufferedReader br = new BufferedReader(new FileReader(n))) {
                String row;
                int rowN = 0;
 
                while ((row = br.readLine()) != null) {
                    rowN++;
                    row = row.trim();
 
                    if (row.isEmpty()) {
                        continue;
                    }
 
                    Double grade = Double.parseDouble(row);

                    if (grade < 0 || grade > 10) {
                        System.out.printf("ATTENZIONE: voto %.1f alla riga %d fuori dal range [0-10], ignorato.%n",grade, rowN);
                        continue;
                    }
 
                    grades.add(grade);
                }
            }
 
            return grades;
        }
 
        public static void scriviFile(String n, ArrayList<Double> grades, double av, Double min, Double max)
                throws IOException {
 
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(n))) {
                bw.write("========================================");
                bw.newLine();
                bw.write("       REPORT VOTI STUDENTI");
                bw.newLine();
                bw.write("========================================");
                bw.newLine();
                bw.newLine();
 
                bw.write("Numero voti letti : " + grades.size());
                bw.newLine();
                bw.write(String.format("Media voti        : %.2f", av));
                bw.newLine();
                bw.write("Voto minimo       : " + min);
                bw.newLine();
                bw.write("Voto massimo      : " + max);
                bw.newLine();
                bw.newLine();
 
                bw.write("Elenco voti:");
                bw.newLine();
                for (int i = 0; i < grades.size(); i++) {
                    bw.write(String.format("  [%2d] %.1f", i + 1, grades.get(i)));
                    bw.newLine();
                }
 
                bw.newLine();
                bw.write("========================================");
                bw.newLine();
            }
        }
    }


    public static void main(String[] args) {
 
        final String FILE_INPUT  = "voti.txt";
        final String FILE_OUTPUT = "output.txt";
 
        System.out.println("=== GestioneVoti avviato ===");
 
        ArrayList<Double> grades;
        try {
            grades = FileManager.leggiFile(FILE_INPUT);

        } catch (IOException e) {
            System.err.println("ERRORE: impossibile leggere il file '" + FILE_INPUT + "'.");
            System.err.println("Dettaglio: " + e.getMessage());
            System.err.println("Assicurati che 'voti.txt' si trovi nella directory di esecuzione.");
            return;

        } catch (NumberFormatException e) {
            System.err.println("ERRORE: il file contiene un valore non numerico.");
            System.err.println("Dettaglio: " + e.getMessage());
            return;
        }

        if (grades.isEmpty()) {
            System.err.println("ERRORE: nessun voto valido trovato in '" + FILE_INPUT + "'.");
            return;
        }
 
        System.out.println("Voti letti: " + grades.size());
 

        Double sum = 0.0;
        for (Double v : grades) {
            sum += v;
        }
        double av = sum / grades.size();

        Double min  = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        for (Double v : grades) {
            if (Double.compare(v, min)  < 0) min  = v;
            if (Double.compare(v, max) > 0) max = v;
        }
 
        // 5. Stampa a console
        System.out.printf("Media  : %.2f%n", av);
        System.out.println("Minimo : " + min);
        System.out.println("Massimo: " + max);
 
        // 6. Scrittura risultati su file tramite FileManager
        try {
            FileManager.scriviFile(FILE_OUTPUT, grades, av, min, max);
            System.out.println("Risultati scritti in '" + FILE_OUTPUT + "'.");
        } catch (IOException e) {
            System.err.println("ERRORE: impossibile scrivere su '" + FILE_OUTPUT + "'.");
            System.err.println("Dettaglio: " + e.getMessage());
        }
 
        System.out.println("=== GestioneVoti terminato ===");
    }
}