public class Floor {

    int n;
    Room[] r;
    int rCnt;

    public Floor(int n) {
        this.n = n;
        this.r = new Room[20];
        this.rCnt = 0;
    }

    public void addR(String name) {
        r[rCnt] = new Room(name);
        rCnt++;
    }

    public Room findR(String name) {
        for (int i = 0; i < rCnt; i++) {
            if (r[i].name.equals(name)) {
                return r[i];
            }
        }
        return null;
    }

    public void turnAllOn() {
        for (int i = 0; i < rCnt; i++) {
            r[i].turnAllOn();
        }
    }

    public void turnAllOff() {
        for (int i = 0; i < rCnt; i++) {
            r[i].turnAllOff();
        }
    }

    public void printStatus() {
        System.out.println("  Floor " + n);
        for (int i = 0; i < rCnt; i++) {
            r[i].printStatus();
        }
    }
}
