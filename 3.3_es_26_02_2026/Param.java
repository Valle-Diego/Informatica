package es26022026;

// La classe ParametriOspedale contiene i limiti clinici e operativi del sistema.
// Si utilizza 'static final' per definire le costanti perché:
// 1. 'static': La costante appartiene alla classe stessa e non alle singole istanze. 
// Viene allocata una sola volta in memoria, rendendo l'accesso efficiente.
// 2. 'final': Impedisce che il valore venga modificato dopo l'inizializzazione, 
// garantendo l'integrità dei dati a runtime.

public class Param {

    // Limiti Età
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 130;

    // Limiti Temperatura (°C)
    public static final double MIN_TEMP = 34.0;
    public static final double MAX_TEMP = 42.0;

    // Limiti Frequenza Cardiaca (BPM)
    public static final int MIN_BPM = 30;
    public static final int MAX_BPM = 220;

    // Saturazione Ossigeno (SpO2)
    public static final int MIN_SAT = 70;

    // Gestione Ricette
    public static final int MAX_DRUGS = 5;

    // Codici Triage
    public static final String CODE_RED = "ROSSO";
    public static final String CODE_ORANGE = "ARANCIO";
    public static final String CODE_GREEN = "VERDE";
    public static final String CODE_WHITE = "BIANCO";
}