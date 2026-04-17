public class Room {

    String name;
    Light[] l;
    int lCnt;

    public Room(String name) {
        this.name = name;
        this.l = new Light[20];
        this.lCnt = 0;
    }

    public void addLight(String lId) {
        l[lCnt] = new Light(lId);
        lCnt++;
    }

    public Light findL(String lId) {
        for (int i = 0; i < lCnt; i++) {
            if (l[i].id.equals(lId)) {
                return l[i];
            }
        }
        return null;
    }

    public void turnAllOn() {
        for (int i = 0; i < lCnt; i++) {
            l[i].turnOn();
        }
    }

    public void turnAllOff() {
        for (int i = 0; i < lCnt; i++) {
            l[i].turnOff();
        }
    }

    public void printStatus() {
        System.out.println("    Room: " + name);
        for (int i = 0; i < lCnt; i++) {
            l[i].printStatus();
        }
    }
}
