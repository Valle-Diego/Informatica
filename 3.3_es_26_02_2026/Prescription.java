package es26022026;

import java.util.List;

public class Prescription {


    // Emette una ricetta validando i farmaci e le autorizzazioni
    // throws InvalidPrescriptionExc se la validazione fallisce

    public void getPrescription(List<String> drugs, boolean enabledDoc) 
            throws InvalidPrescriptionExc {
        
        // 1. Lancia NoAuthorizationExc (unchecked) se il medico non è abilitato
        if (!enabledDoc) {
            throw new NoAuthorizationExc("Accesso negato", "Dr. Rossi", "Emissione Ricetta");
        }

        try {
            // 2. Validazione interna della lista farmaci
            if (drugs == null || drugs.isEmpty()) {
                throw new IllegalArgumentException("La lista dei farmaci non può essere vuota.");
            }
            if (drugs.size() > Param.MAX_DRUGS) {
                throw new IllegalArgumentException("Superato il limite massimo di " + Param.MAX_DRUGS + " farmaci.");
            }

            System.out.println("Ricetta valida per i farmaci: " + drugs);

        } catch (IllegalArgumentException e) {
            // 3. Cattura l'eccezione interna e la rilancia come InvalidPrescriptionExc 
            // Passiamo l'originale 'e' come c nel costruttore 
            throw new InvalidPrescriptionExc("Impossibile emettere la ricetta per motivi tecnici.", e);
        }
    }
}