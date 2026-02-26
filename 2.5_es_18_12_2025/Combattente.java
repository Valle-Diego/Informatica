package es181225;

public interface Combattente {
    int getPuntiFerita();
    void subisciDanno(int danno);
    void attacca(Combattente target);
    boolean isVivo();
}