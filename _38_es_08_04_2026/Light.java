public class Light {

    String id;
    boolean isOn;
    int br;

    String scOnTime;
    String scOffTime;

    public Light(String id) {
        this.id = id;
        this.isOn = false;
        this.br = 100;
        this.scOnTime = null;
        this.scOffTime = null;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void toggle() {
        if (isOn) {
            isOn = false;
        } else {
            isOn = true;
        }
    }

    public void setBrightness(int lv) {
        if (lv < 0 || lv > 100) {
            System.out.println("Brightness must be between 0 and 100.");
            return;
        }
        br = lv;
        if (lv == 0) {
            isOn = false;
        } else {
            isOn = true;
        }
    }

    public void setSchedule(String onTime, String offTime) {
        scOnTime = onTime;
        scOffTime = offTime;
    }

    public void clearSchedule() {
        scOnTime = null;
        scOffTime = null;
    }

    private int timeToM(String t) {
        String[] parts = t.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    public void applySchedule(String ctTime) {
        if (scOnTime == null || scOffTime == null) {
            return;
        }

        int now = timeToM(ctTime);
        int on  = timeToM(scOnTime);
        int off = timeToM(scOffTime);

        if (on < off) {
            if (now >= on && now < off) {
                isOn = true;
            } else {
                isOn = false;
            }
        } else {
            if (now >= on || now < off) {
                isOn = true;
            } else {
                isOn = false;
            }
        }
    }

    public void printStatus() {
        String state = isOn ? "ON " : "OFF";
        System.out.print("      Light " + id + " [" + state + "] " + br + "%");
        if (scOnTime != null) {
            System.out.print("  schedule: " + scOnTime + " - " + scOffTime);
        }
        System.out.println();
    }
}
