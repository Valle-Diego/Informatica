package _25_es_18_12_2025;

public interface Combattente {
    int getPuntiFerita();
    void subisciDanno(int danno);
    void attacca(Combattente target);
    boolean isVivo();
}