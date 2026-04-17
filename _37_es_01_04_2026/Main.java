package _37_es_01_04_2026;

public class Main {
    public static void main(String[] args) {

        // Contenitore String
        Contenitore<String> c1 = new Contenitore<>();
        c1.set("Ciao");
        System.out.println("String: " + c1.get());

        // Contenitore Integer
        Contenitore<Integer> c2 = new Contenitore<>();
        c2.set(10);
        System.out.println("Integer: " + c2.get());

        // Coppia
        Coppia<String, Integer> studente = new Coppia<>("Mario", 28);
        System.out.println("Nome: " + studente.primo);
        System.out.println("Voto: " + studente.secondo);

        // BONUS
        Calcolatore<Integer> calc = new Calcolatore<>();
        System.out.println("Somma: " + calc.somma(5, 7));
    }
}