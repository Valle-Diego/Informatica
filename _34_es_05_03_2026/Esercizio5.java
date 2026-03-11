package _34_es_05_03_2026;

import java.io.*;

public class Esercizio5 {

    static void aggiungiContatto(String nome, String cognome, String tel) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("rubrica.txt", true))) {

            bw.write(nome + ";" + cognome + ";" + tel);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    static void cercaContatto(String nome) {

        try (BufferedReader br = new BufferedReader(new FileReader("rubrica.txt"))) {

            String riga;

            while ((riga = br.readLine()) != null) {

                String[] campi = riga.split(";");

                if (campi[0].equalsIgnoreCase(nome)) {
                    System.out.println("Trovato: " + campi[0] + " " + campi[1] + " - " + campi[2]);
                }
            }

        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        aggiungiContatto("Mario", "Rossi", "123456");
        aggiungiContatto("Luca", "Bianchi", "987654");
        aggiungiContatto("Anna", "Verdi", "456789");

        cercaContatto("Mario");
    }
}