package GiocoFormica;

public class Formica {

    //Dichiaro Variabili
    private String N;
    private int E;
    private int x, y;
    private boolean status;

    //Costruttore
    public Formica(String N, int EIn) {
        this.N = N;
        this.E = EIn;
        this.x = 0;
        this.y = 0;
        this.status = true;
    }

    //get
    public String getN() {
        return N;
    }

    public int getE() {
        return E;
    }

    public boolean getStatus() {
        return status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

private String getDir(int Dir) {
    switch (Dir) {
        case 0:
            return "NORD";
        case 1:
            return "SUD";
        case 2:
            return "EST";
        case 3:
            return "OVEST";
        default:
            return "IGNOTA";
    }
}


    // Metodo move
    public void move() {
        if (status = false) {
            System.out.println(N + " non può muoversi: è morta.");
            return;
        }
        // 0 = NORD, 1 = SUD, 2 = EST, 3 = OVEST
        int Dir = (int)(Math.random()*4);

        switch (Dir) {
            case 0: y++; // NORD
            case 1: y--; // SUD
            case 2: x++; // EST
            case 3: x--; // OVEST
        }

        E--;

        System.out.println(N + " si è mossa in direzione " + getDir(Dir) + " verso (" + x + ", " + y + "). Energia residua: " + E);

        //Morte
        if (E <= 0) {
            status = false;
            System.out.println(N + " è morta... (GODO)");
        }
    }

    // Metodo mangiare
    public void eat(int food) {
        if (status==false) {
            System.out.println(N + " non può mangiare: è morta.");
            return;
        }

        E += food;
        System.out.println(N + " ha mangiato e ora ha " + E + " di energia.");
    }

    
    //toString
    public String toString() {
        String S = status ? "viva" : "morta";
        return "Formica{" + "nome = " + N + ", energia = " + E + ", posizione = (" + x + ", " + y + ")" + ", Status = " + S + '}';
    }   
}
