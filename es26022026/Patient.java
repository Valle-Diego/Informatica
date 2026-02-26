package es26022026;

public class Patient {
    private String cf;
    private String n;
    private int age;
    private String code;

    // Costruttore: valida i dati anagrafici del paziente
    // throws DataExc (checked) se i dati non rispettano i criteri
   
    public Patient(String cf, String n, int age) throws DataExc {
        // Validazione Codice Fiscale (16 caratteri)
        if (cf == null || cf.length() != 16) {
            throw new DataExc("Il CF deve essere di 16 caratteri.", "Codice Fiscale", cf);
        }
        // Validazione Nome (non vuoto)
        if (n == null || n.trim().isEmpty()) {
            throw new DataExc("Il nome non può essere vuoto.", "Nome", n);
        }
        // Validazione Età (limiti da ParametriOspedale)
        if (age < Param.MIN_AGE || age > Param.MAX_AGE) {
            throw new DataExc("Età fuori dai limiti consentiti.", "Età", age);
        }

        this.cf = cf;
        this.n = n;
        this.age = age;
    }

    // Registra i parametri vitali e determina il codice triage

    public void lifeParamRec(double temp, int fc, int spo2) throws LifeParamExc {
        // Validazione Temperatura
        if (temp < Param.MIN_TEMP || temp > Param.MAX_TEMP) {
            throw new LifeParamExc("Temperatura fuori norma.", "Temperatura", temp, Param.MIN_TEMP, Param.MAX_TEMP);
        }
        // Validazione Frequenza Cardiaca
        if (fc < Param.MIN_BPM || fc > Param.MAX_BPM) {
            throw new LifeParamExc("Frequenza cardiaca critica.", "FC", fc, Param.MIN_BPM, Param.MAX_BPM);
        }
        // Validazione Saturazione O2
        if (spo2 < Param.MIN_SAT) {
            throw new LifeParamExc("Saturazione ossigeno troppo bassa.", "SpO2", spo2, Param.MIN_SAT, 100);
        }

        // Logica per determinare il Triage
        if (temp > 40 || spo2 < 85) {
            this.code = Param.CODE_RED;
        } else if (temp > 38 || spo2 < 92) {
            this.code = Param.CODE_ORANGE;
        } else if (temp > 37) {
            this.code = Param.CODE_GREEN;
        } else {
            this.code = Param.CODE_WHITE;
        }
        
        System.out.println("Parametri registrati. Triage assegnato: " + this.code);
    }

    // Assegna un letto nel reparto specificato
    // throws FullExc (unchecked) se i letti sono <= 0
    public void getBed(String dep, int freeBeds) {
        if (freeBeds <= 0) {
            // Non va dichiarata in 'throws' perchè unchecked
            throw new FullExc(dep);
        }
        System.out.println("Paziente assegnato con successo al reparto: " + dep);
    }

    // Getter per nome
    public String getNome() { 
        return n; 
    }
}