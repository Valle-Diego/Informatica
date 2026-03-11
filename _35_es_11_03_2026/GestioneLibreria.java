package _35_es_11_03_2026;

import java.io.*;
import java.util.*;

public class GestioneLibreria {
    private String nomeLibreria;
    public ArrayList<Libro> catalogo = new ArrayList<>();

    public GestioneLibreria(String nome) {
        this.nomeLibreria = nome;
    }

    public void aggiungiLibro(String titolo, String autore, int anno, double prezzo) {
        catalogo.add(new Libro(titolo, autore, anno, prezzo));
    }

    public void mostraCatalogo() {
        System.out.println("=== Catalogo: " + nomeLibreria + " ===");
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + catalogo.get(i).toString());
        }
    }

    public class Libro {
        private String titolo, autore;
        private int anno;
        private double prezzo;

        public Libro(String titolo, String autore, int anno, double prezzo) {
            this.titolo = titolo; this.autore = autore; this.anno = anno; this.prezzo = prezzo;
        }

        public String toCSV() { return titolo + ";" + autore + ";" + anno + ";" + prezzo; }
        
        @Override
        public String toString() { 
            return titolo + " | " + autore + " (" + anno + ") EUR " + prezzo; 
        }
    }

    public static class CatalogoIO {
        public static void salva(ArrayList<Libro> libri, String percorso) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(percorso))) {
                for (Libro l : libri) {
                    bw.write(l.toCSV());
                    bw.newLine();
                }
            }
        }

        public static ArrayList<Libro> carica(String percorso) throws IOException {
            ArrayList<Libro> caricati = new ArrayList<>();
            GestioneLibreria temp = new GestioneLibreria("Temp");
            try (BufferedReader br = new BufferedReader(new FileReader(percorso))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] p = linea.split(";");
                    caricati.add(temp.new Libro(p[0], p[1], Integer.parseInt(p[2]), Double.parseDouble(p[3])));
                }
            }
            return caricati;
        }

        public static void esportaReport(ArrayList<Libro> libri, String percorso) throws IOException {
            double totalePrezzi = 0;
            Libro caro = libri.get(0);
            Libro economico = libri.get(0);
            for (Libro l : libri) {
                totalePrezzi += l.prezzo;
                if (l.prezzo > caro.prezzo) 
                    caro = l;
                if (l.prezzo < economico.prezzo) 
                    economico = l;     
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(percorso))) {
                bw.write("=== REPORT LIBRERIA ==="); bw.newLine();
                bw.write("Totale libri: " + libri.size()); bw.newLine();
                bw.write(String.format("Prezzo medio: %.2f", (totalePrezzi / libri.size()))); bw.newLine();
                bw.write("Libro più caro: " + caro.titolo); bw.newLine();
                bw.write("Libro più economico: " + economico.titolo);
            }
        }
    }
}