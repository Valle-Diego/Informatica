package Tris;

public class Tris {
         
    private char m [][] = new char[5][5];
    private char s1;
    private char s2;
    private boolean G1;

    public Tris(){
        this.G1 = true;
        CreaM();
    }

    public void CreaM(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(i%2==0 && j%2==0){
                    m[i][j] = ' ';
                } else if(i%2==0 && j%2!=0){
                    m[i][j] = '|';
                } else if(i%2!=0 && j%2==0){
                    m[i][j] = '-';
                } else {
                    m[i][j] = '+';
                }
            }
        }
    }

    public void PrintM(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    private int convCord(int n){
        if (n == 1) return 0;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return -1;
    }

    public void setS(char s){
        s1 = Character.toUpperCase(s);
        s2 = (s1 == 'X') ? 'O' : 'X';
    }

    public boolean Move(int x, int y) {
        int r = convCord(x);
        int c = convCord(y);
        char s = G1 ? s1 : s2;

        if (r == -1 || c == -1) {
            System.out.println("Coordinate non valide! Usa numeri tra 1 e 3.");
            return false;
        }
        if (m[r][c] == ' ') {
            m[r][c] = s;
            return true;
        } else {
            System.out.println("Casella già occupata! Riprova.");
            return false;
        }
    }

    public boolean controlWin(char s) {
        // Righe
        for (int i = 0; i < 5; i += 2) {
            if (m[i][0] == s && m[i][2] == s && m[i][4] == s)
                return true;
        }
        // Colonne
        for (int j = 0; j < 5; j += 2) {
            if (m[0][j] == s && m[2][j] == s && m[4][j] == s)
                return true;
        }
        // Diagonali
        if (m[0][0] == s && m[2][2] == s && m[4][4] == s)
            return true;
        if (m[0][4] == s && m[2][2] == s && m[4][0] == s)
            return true;

        return false;
    }

    public boolean FullGrid() {
        for (int i = 0; i < 5; i += 2) {
            for (int j = 0; j < 5; j += 2) {
                if (m[i][j] == ' ') return false;
            }
        }
        return true;
    }


    public char getS(){
        return G1 ? s1 : s2;
    }
    public void SwTurn(){
        G1 = !G1;
    }
    public boolean getG1(){
        return G1;
    }
    

}
