package _35_es_11_03_2026;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {

            GestioneLibreria lib = new GestioneLibreria("Libreria Centrale");

            lib.aggiungiLibro("Il Nome della Rosa", "Umberto Eco", 1980, 14.90);
            lib.aggiungiLibro("1984", "George Orwell", 1949, 9.90);
            lib.aggiungiLibro("Il Piccolo Principe", "Antoine de Saint-Exupery", 1943, 7.50);
            lib.aggiungiLibro("Dune", "Frank Herbert", 1965, 12.00);

            lib.mostraCatalogo();

            GestioneLibreria.CatalogoIO.salva(lib.catalogo, "catalogo.csv");

            ArrayList<GestioneLibreria.Libro> ricaricati = 
                GestioneLibreria.CatalogoIO.carica("catalogo.csv");
            
            System.out.println("Libri ricaricati: " + ricaricati.size());

            GestioneLibreria.CatalogoIO.esportaReport(lib.catalogo, "report.txt");
            System.out.println("Report scritto su report.txt");

        } catch (IOException e) {
            System.err.println("Errore durante la gestione dei file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Errore nel parsing dei dati: " + e.getMessage());
        }
    }
}