package es181225;

public abstract class Entita implements Combattente {
    protected String nome;
    protected int maxPF;
    protected int pfCorrenti;
    protected int attaccoBase;
    protected int difesaBase;

    public Entita(String nome, int maxPF, int attaccoBase, int difesaBase) {
        this.nome = nome;
        this.maxPF = maxPF;
        this.pfCorrenti = maxPF;
        this.attaccoBase = attaccoBase;
        this.difesaBase = difesaBase;
    }

    // Implementazione dei metodi dell'interfaccia Combattente (senza @Override)
    public int getPuntiFerita() {
        return pfCorrenti;
    }

    public boolean isVivo() {
        return pfCorrenti > 0;
    }

    public void attacca(Combattente target) {
        // Calcolo del modificatore casuale di danno (tra 0.9 e 1.1)
        double modCasuale = 0.9 + (Math.random() * 0.2); 
        int dannoGrezzo = (int) (attaccoBase * modCasuale);
        
        System.out.println(this.nome + " attacca " + ((Entita)target).nome + " per " + dannoGrezzo + " di danno grezzo.");
        target.subisciDanno(dannoGrezzo);
    }
    
    public void subisciDanno(int danno) {
        // Chance di Blocco (20% di chance di ridurre il danno)
        if (Math.random() < 0.20) { 
            danno = danno / 2;
            System.out.println(this.nome + " è riuscito a bloccare parte dell'attacco.");
        }
        
        // Calcolo del danno finale
        int dannoFinale;
        
        if (danno > difesaBase) {
            dannoFinale = danno - difesaBase;
        } else {
            // Danno minimo garantito
            dannoFinale = 1; 
        }

        this.pfCorrenti -= dannoFinale;
        
        System.out.println(this.nome + " subisce " + dannoFinale + " di danno finale. PF rimanenti: " + pfCorrenti);

        if (!isVivo()) {
            System.out.println(this.nome + " è stato sconfitto.");
        }
    }
    
    // Metodo astratto che definisce il comportamento in un turno
    public abstract void turno(Combattente target); 

    public String toString() {
        return nome + " [HP: " + pfCorrenti + "/" + maxPF + ", ATK: " + attaccoBase + ", DEF: " + difesaBase + "]";
    }
}