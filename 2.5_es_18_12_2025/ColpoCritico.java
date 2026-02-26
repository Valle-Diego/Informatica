package es181225;

public class ColpoCritico implements Abilita {
    public String getNome() {
        return "Colpo Critico";
    }

    public void usa(Combattente caster, Combattente target) {
        // Logica: Chance di successo del 40% (0.4)
        if (Math.random() < 0.4) {
            // CRITICO RIUSCITO
            int dannoCritico = ((Entita)caster).attaccoBase * 2;

            System.out.println(caster.toString() + " usa " + getNome() + ". Colpo CRITICO. Danno calcolato: " + dannoCritico);
            target.subisciDanno(dannoCritico);
        } else {
            // CRITICO FALLITO - Attacco normale
            System.out.println(caster.toString() + " usa " + getNome() + " ma fallisce. Esegue un attacco normale.");
            caster.attacca(target); 
        }
    }
}