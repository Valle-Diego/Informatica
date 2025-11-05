package es051125;

import java.util.ArrayList;

// Classe che gestisce la collezione di film
public class Videoteca {
    private ArrayList<Film> lista; // elenco dei film

    // Costruttore
    public Videoteca() {
        lista = new ArrayList<>();
    }

    // Aggiunge un film (evita duplicati)
    public void addF(Film f) {
        for (Film x : lista) {
            if (x.getTitolo().equals(f.getTitolo())) {
                System.out.println(" Film già presente!");
                return;
            }
        }
        lista.add(f);
        System.out.println(" Film aggiunto!");
    }

    // Mostra tutti i film
    public void showF() {
        if (lista.isEmpty()) {
            System.out.println(" Videoteca vuota.");
        } else {
            System.out.println("\n Elenco film:");
            for (Film f : lista)
                System.out.println("- " + f);
        }
    }

    // Cerca un film per titolo
    public Film searchF(String titolo) {
        for (Film f : lista) {
            if (f.getTitolo().equals(titolo))
                return f;
        }
        return null; // non trovato
    }

    // Rimuove un film per titolo
    public boolean removeF(String titolo) {
        Film trovato = searchF(titolo);
        if (trovato != null) {
            lista.remove(trovato);
            return true;
        }
        return false;
    }
}
