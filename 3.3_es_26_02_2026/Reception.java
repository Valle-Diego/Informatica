package es26022026;

public class Reception {

    
    // Gestisce l'accettazione completa di un paziente in tre fasi distinte.
    
    public static void acceptPat(String cf, String n, int age, double temp, int fc, int spo2, String dep, int freeBeds) {
        Patient p = null;

        // FASE 1: Creazione del paziente
        try {
            p = new Patient(cf, n, age);
            System.out.println("Paziente creato con successo.");
        } catch (DataExc e) {
            // Cattura l'eccezione specifica e stampa il problema
            System.err.println("ERRORE CREAZIONE: Dati non validi. " + e.getMessage());
        } finally {
            // Messaggio di audit sempre eseguito
            System.out.println("[AUDIT LOG]: Fase creazione terminata.");
        }

        // Procediamo con le fasi successive solo se l'oggetto Paziente è stato creato
        if (p != null) {
            
            // FASE 2: Rilevazione parametri vitali
            try {
                p.lifeParamRec(temp, fc, spo2);
            } catch (LifeParamExc e) {
                System.err.println("ERRORE CLINICO: " + e.getMessage());
                // Se è un'emergenza, attiviamo il protocollo specifico
                if (e.isEmergency()) {
                    System.err.println("!!! ALLERTA: Attivazione protocollo urgente !!!");
                }
            } finally {
                // Log di completamento rilevazione
                System.out.println("Rilevazione parametri conclusa.");
            }

            // FASE 3: Assegnazione letto
            try {
                p.getBed(dep, freeBeds);
            } catch (FullExc e) {
                // Gestione dell'eccezione Unchecked (anche se non obbligatoria, qui richiesta) 
                System.err.println("ERRORE LOGISTICO: " + e.getMessage());
            } finally {
                // Messaggio finale della procedura [cite: 83]
                System.out.println("Procedura di assegnazione terminata.");
            }
        } else {
            System.err.println("Impossibile procedere: Paziente non valido.");
        }
        
        System.out.println("=== Fine processo per il paziente: " + n + " ===");
    }
}