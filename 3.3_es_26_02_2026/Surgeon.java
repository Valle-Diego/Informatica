package es26022026;

// Estende Medico e gestisce i turni operativi
public class Surgeon extends Doctor {
    // Costante per il limite ore turno
    private final int MAX_HOURS = 12; 
    
    // Campo privato per le ore lavorate
    private int hoursToday;

    public Surgeon(String n, int hoursToday) {
        super(n);
        this.hoursToday = hoursToday;
    }

    
    // Tenta di iniziare un'operazione su un paziente
    // Lancia NoAuthorizationExc se il turno è terminato

    public void startOperation(Patient p) {
        if (this.hoursToday >= MAX_HOURS) {
            // L'eccezione è unchecked, quindi non serve dichiararla nel throws
            throw new NoAuthorizationExc("Il chirurgo " + n + " ha superato il limite ore.", n, "Chirurgia");
        }
        System.out.println("Intervento iniziato per il paziente: " + p.getNome());
    }
}