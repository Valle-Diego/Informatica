package es131125;

public class Flight {
    private String c;
    private String depC;
    private String arrC;
    private int totS;
    private int bookS;

    public Flight(String c, String depC, String arrC, int totS){
        this.c = c;
        this.depC = depC;
        this.arrC = arrC;
        this.totS = totS;
        this.bookS = 0;
    }

    public boolean avS() {
        return bookS < totS;
    }

    public boolean bookAS(){
        if(avS()) {
            bookS++;
            return true;
        } else {
            return false;
        }
    }

    public void canS(){
        if(bookS > 0)
            bookS--;
    }

    public String getC(){
        return c;
    }
    
    public String getDepC(){
        return c;
    }

    public String getArrC(){
        return c;
    }

    public int getAvS(){
        return totS - bookS;
    }

    public String toString() {
        return "Volo " + c + " da " + depC + " a " + arrC + " | Posti liberi: " + getAvS();
    }
}
