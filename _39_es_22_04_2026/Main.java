// File: Main.java
public class Main {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // PARTE 2 — Creare e usare oggetti Treno
        // -------------------------------------------------------

        // STEP 1: Crea tre treni
        Treno fr9600 = new Treno("FR9600", "Roma", 400);
        Treno r2201  = new Treno("R2201", "Brescia", 180);
        Treno ic521  = new Treno("IC521", "Genova", 250);

        // STEP 2: Stampa le informazioni di tutti e tre
        fr9600.stampaInfo();
        System.out.println("---");
        r2201.stampaInfo();
        System.out.println("---");
        ic521.stampaInfo();

        // STEP 3: Prenota 3 posti sul Frecciarossa
        fr9600.prenota();
        fr9600.prenota();
        fr9600.prenota();

        // Quanti posti liberi rimangono?
        System.out.println("Posti liberi FR9600: " + fr9600.getPostiLiberi());

        // STEP 4: Segnala il ritardo del Regionale
        r2201.segnalaRitardo();
        r2201.stampaInfo();

        // -------------------------------------------------------
        // PARTE 3 — Testa isSaturo()
        // -------------------------------------------------------
        if (fr9600.isSaturo()) {
            System.out.println(fr9600.getCodice() + " e' quasi pieno!");
        } else {
            System.out.println(fr9600.getCodice() + " ha ancora posti disponibili.");
        }

        // -------------------------------------------------------
        // PARTE 4 — Usa la Stazione
        // -------------------------------------------------------

        // Crea la stazione di Milano
        Stazione milano = new Stazione("Milano Centrale");

        // Aggiungi i tre treni alla stazione
        milano.aggiungiTreno(fr9600);
        milano.aggiungiTreno(r2201);
        milano.aggiungiTreno(ic521);

        // Stampa le partenze
        milano.stampaPartenze();

        // Stampa quanti treni sono in ritardo
        int ritardi = milano.contaTreniInRitardo();
        System.out.println("Treni in ritardo: " + ritardi);

        // -------------------------------------------------------
        // PARTE 5 — Usa TrenoAltaVelocita
        // -------------------------------------------------------

        // Crea un treno AV: codice "AV300", dest. "Napoli",
        // 350 posti, 300 km/h, 0.40 euro/km
        TrenoAltaVelocita av = new TrenoAltaVelocita("AV300", "Napoli", 350, 300, 0.40);

        // Stampa le info (chiama stampaInfo() di TrenoAltaVelocita)
        av.stampaInfo();

        // Calcola il prezzo per Milano-Napoli (721 km)
        double prezzo = av.calcolaPrezzo(721);
        System.out.println("Prezzo Milano-Napoli: " + prezzo + " euro");

        // Aggiungi av alla stazione — funziona perche' TrenoAltaVelocita E' un Treno
        milano.aggiungiTreno(av);
        milano.stampaPartenze();
    }
}
