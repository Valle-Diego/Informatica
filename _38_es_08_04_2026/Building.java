public class Building {

    String name;
    Floor[] fl;
    int flCnt;

    public Building(String name) {
        this.name = name;
        this.fl = new Floor[50]; // max 50 floors
        this.flCnt = 0;
    }

    public void addFl(int n) {
        fl[flCnt] = new Floor(n);
        flCnt++;
    }

    public Floor findFl(int n) {
        for (int i = 0; i < flCnt; i++) {
            if (fl[i].n == n) {
                return fl[i];
            }
        }
        return null; // not found
    }

    public void turnAllOn() {
        for (int i = 0; i < flCnt; i++) {
            fl[i].turnAllOn();
        }
    }

    public void turnAllOff() {
        for (int i = 0; i < flCnt; i++) {
            fl[i].turnAllOff();
        }
    }

    public void printStatus() {
        System.out.println("=== Building: " + name + " ===");
        for (int i = 0; i < flCnt; i++) {
            fl[i].printStatus();
        }
    }
}
