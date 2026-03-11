package _35_es_11_03_2026;

import java.io.*;
import java.util.*;

public class RegistroVoti {

    public static void scriviStudenti(String percorso, String[][] dati) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(percorso))) {
            for (String[] riga : dati) {
                bw.write(riga[0] + ";" + riga[1] + ";" + riga[2]);
                bw.newLine();
            }
            bw.flush();
        }
    }

    public static List<String> leggiStudenti(String percorso) throws IOException {
        List<String> righe = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(percorso))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                if (!riga.isBlank()) {
                    righe.add(riga);
                    System.out.println("[LETTO] " + riga);
                }
            }
        }
        return righe;
    }

    public static void scriviReport(String percorsoInput, String percorsoOutput) throws IOException {
        List<String> righe = leggiStudenti(percorsoInput);
        double somma = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;

        for (String s : righe) {
            double voto = Double.parseDouble(s.split(";")[2]);
            somma += voto;
            if (voto < min) min = voto;
            if (voto > max) max = voto;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(percorsoOutput))) {
            bw.write("=== REPORT VOTI ==="); bw.newLine();
            bw.write("Totale studenti: " + righe.size()); bw.newLine();
            bw.write(String.format("Media classe: %.2f", (somma / righe.size()))); bw.newLine();
            bw.write("Voto minimo: " + (int)min); bw.newLine();
            bw.write("Voto massimo: " + (int)max);
        }
    }
}