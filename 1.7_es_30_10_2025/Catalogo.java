package es301025;

import java.util.*;

public class Catalogo {

    // Dichiaro ArrayList<Libro>
    private ArrayList<Libro> L;

    // Creo un nuovo ArrayList
    public Catalogo() {
        L = new ArrayList<>();
    }

    // Metodo per aggiungere Libri
    public void addL(Libro libro) {
        L.add(libro);
    }

    // Mostrare catalogo
    public void showCat() {
        if (L.isEmpty()) {
            System.out.println("Il catalogo è vuoto."); // Controllo se il catalogo è vuoto
        } else {
            for (Libro l : L) {
                System.out.println(l);
            }
        }
    }

    // Ricerca libri
    public Libro searchxT(String t) {
        for (Libro l : L) {
            if (l.getT().toLowerCase().equals(t.toLowerCase())) { // confronto manuale in minuscolo
                return l;
            }
        }
        return null;
    }

    // Rimozione libri
    public boolean removeL(String t) {
        Libro toR = searchxT(t);
        if (toR == null) { // controllo diretto
            return false;
        } else {
            L.remove(toR);
            return true;
        }
    }

    // 🔹 Ordinamento per titolo (bubble sort)
    public void sortxT() {
        for (int i = 0; i < L.size() - 1; i++) {
            for (int j = 0; j < L.size() - i - 1; j++) {
                Libro l1 = L.get(j);
                Libro l2 = L.get(j + 1);
                if (l1.getT().toLowerCase().compareTo(l2.getT().toLowerCase()) > 0) {
                    // scambio
                    L.set(j, l2);
                    L.set(j + 1, l1);
                }
            }
        }
        System.out.println("Catalogo ordinato per titolo.");
    }

    // 🔹 Ordinamento per autore (bubble sort)
    public void sortxA() {
        for (int i = 0; i < L.size() - 1; i++) {
            for (int j = 0; j < L.size() - i - 1; j++) {
                Libro l1 = L.get(j);
                Libro l2 = L.get(j + 1);
                if (l1.getA().toLowerCase().compareTo(l2.getA().toLowerCase()) > 0) {
                    // scambio
                    L.set(j, l2);
                    L.set(j + 1, l1);
                }
            }
        }
        System.out.println("Catalogo ordinato per autore.");
    }
}
