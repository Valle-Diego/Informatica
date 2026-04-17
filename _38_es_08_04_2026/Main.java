import java.util.*;

public class Main {

    static Building building;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Building Light Manager ===");
        System.out.println();

        setupBuilding();

        System.out.println();
        System.out.println("Building Configured! Type 'help' to see the commands.");
        System.out.println();

        while (true) {
            System.out.print("> ");
            String in = sc.nextLine().trim();

            if (in.isEmpty()) {
                continue;
            }

            String[] pts = in.split(" ");
            String cmd = pts[0];

            switch (cmd) {

                case "help":
                    printHelp();
                    break;

                case "status":
                    building.printStatus();
                    break;

                case "exit":
                    System.out.println("Bye!");
                    sc.close();
                    return;

                case "building":
                    if (pts.length < 2) {
                        System.out.println("Use: building on|off");
                        break;
                    }
                    switch (pts[1]) {
                        case "on":
                            building.turnAllOn();
                            System.out.println("All Lights On.");
                            break;
                        case "off":
                            building.turnAllOff();
                            System.out.println("All Lights Off.");
                            break;
                        default:
                            System.out.println("Invalid. Use: building on|off");
                    }
                    break;

                case "floor":
                    if (pts.length < 3) {
                        System.out.println("Use: floor <number> on|off");
                        break;
                    }
                    int floorNum = Integer.parseInt(pts[1]);
                    Floor floor = building.findFl(floorNum);
                    if (floor == null) {
                        System.out.println("Floor " + floorNum + " not found.");
                        break;
                    }
                    switch (pts[2]) {
                        case "on":
                            floor.turnAllOn();
                            System.out.println("Floor " + floorNum + " on.");
                            break;
                        case "off":
                            floor.turnAllOff();
                            System.out.println("Floor " + floorNum + " off.");
                            break;
                        default:
                            System.out.println("Invalid. Use: on|off");
                    }
                    break;

                case "room":
                    if (pts.length < 4) {
                        System.out.println("Use: room <floor> <n> on|off");
                        break;
                    }
                    floorNum = Integer.parseInt(pts[1]);
                    floor = building.findFl(floorNum);
                    if (floor == null) {
                        System.out.println("Floor " + floorNum + " not found.");
                        break;
                    }
                    Room room = floor.findR(pts[2]);
                    if (room == null) {
                        System.out.println("Room " + pts[2] + " not found.");
                        break;
                    }
                    switch (pts[3]) {
                        case "on":
                            room.turnAllOn();
                            System.out.println("Room " + pts[2] + " on.");
                            break;
                        case "off":
                            room.turnAllOff();
                            System.out.println("Room " + pts[2] + " off.");
                            break;
                        default:
                            System.out.println("Invalid. Use: on|off");
                    }
                    break;

                case "light":
                    if (pts.length < 5) {
                        System.out.println("Use: light <floor> <room> <id> on|off|toggle");
                        break;
                    }
                    floorNum = Integer.parseInt(pts[1]);
                    floor = building.findFl(floorNum);
                    if (floor == null) {
                        System.out.println("Floor " + floorNum + " not found.");
                        break;
                    }
                    room = floor.findR(pts[2]);
                    if (room == null) {
                        System.out.println("Room " + pts[2] + " not found.");
                        break;
                    }
                    Light light = room.findL(pts[3]);
                    if (light == null) {
                        System.out.println("Light " + pts[3] + " not found.");
                        break;
                    }
                    switch (pts[4]) {
                        case "on":
                            light.turnOn();
                            break;
                        case "off":
                            light.turnOff();
                            break;
                        case "toggle":
                            light.toggle();
                            break;
                        default:
                            System.out.println("Invalid option. Use: on|off|toggle");
                    }
                    light.printStatus();
                    break;

                case "dim":
                    if (pts.length < 5) {
                        System.out.println("Use: dim <floor> <room> <id> <0-100>");
                        break;
                    }
                    floorNum = Integer.parseInt(pts[1]);
                    floor = building.findFl(floorNum);
                    if (floor == null) {
                        System.out.println("Floor " + floorNum + " not found.");
                        break;
                    }
                    room = floor.findR(pts[2]);
                    if (room == null) {
                        System.out.println("Room " + pts[2] + " not found.");
                        break;
                    }
                    light = room.findL(pts[3]);
                    if (light == null) {
                        System.out.println("Light " + pts[3] + " not found.");
                        break;
                    }
                    int level = Integer.parseInt(pts[4]);
                    light.setBrightness(level);
                    light.printStatus();
                    break;

                case "schedule":
                    if (pts.length < 5) {
                        System.out.println("Use: schedule <floor> <room> <id> <HH:MM> <HH:MM>");
                        System.out.println("     schedule <floor> <room> <id> clear");
                        break;
                    }
                    floorNum = Integer.parseInt(pts[1]);
                    floor = building.findFl(floorNum);
                    if (floor == null) {
                        System.out.println("Floor " + floorNum + " not found.");
                        break;
                    }
                    room = floor.findR(pts[2]);
                    if (room == null) {
                        System.out.println("Room " + pts[2] + " not found.");
                        break;
                    }
                    light = room.findL(pts[3]);
                    if (light == null) {
                        System.out.println("Light " + pts[3] + " not found.");
                        break;
                    }
                    if (pts[4].equals("clear")) {
                        light.clearSchedule();
                        System.out.println("Schedule cleared.");
                    } else {
                        if (pts.length < 6) {
                            System.out.println("Use: schedule <floor> <room> <id> <HH:MM> <HH:MM>");
                            break;
                        }
                        light.setSchedule(pts[4], pts[5]);
                        System.out.println("Schedule set: ON at " + pts[4] + ", OFF at " + pts[5]);
                    }
                    break;

                case "tick":
                    if (pts.length < 2) {
                        System.out.println("Use: tick <HH:MM>");
                        break;
                    }
                    String time = pts[1];
                    for (int i = 0; i < building.flCnt; i++) {
                        Floor f = building.fl[i];
                        for (int j = 0; j < f.rCnt; j++) {
                            Room r = f.r[j];
                            for (int k = 0; k < r.lCnt; k++) {
                                r.l[k].applySchedule(time);
                            }
                        }
                    }
                    System.out.println("Schedules applied for time " + time + ".");
                    break;

                default:
                    System.out.println("Unknown command: " + cmd + ". Type 'help'.");
            }
        }
    }

    static void setupBuilding() {
        System.out.print("Building name: ");
        String buildingName = sc.nextLine().trim();
        building = new Building(buildingName);

        System.out.print("How many floors? ");
        int numFloors = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < numFloors; i++) {
            int floorNumber = i + 1;
            building.addFl(floorNumber);
            Floor floor = building.findFl(floorNumber);

            System.out.println();
            System.out.println("--- Floor " + floorNumber + " ---");

            System.out.print("  How many rooms on floor " + floorNumber + "? ");
            int numRooms = Integer.parseInt(sc.nextLine().trim());

            for (int j = 0; j < numRooms; j++) {
                System.out.print("  Room " + (j + 1) + " name: ");
                String roomName = sc.nextLine().trim();
                floor.addR(roomName);
                Room room = floor.findR(roomName);

                System.out.print("    How many lights in '" + roomName + "'? ");
                int numLights = Integer.parseInt(sc.nextLine().trim());

                for (int k = 0; k < numLights; k++) {
                    System.out.print("    Light " + (k + 1) + " ID: ");
                    String lightId = sc.nextLine().trim();
                    room.addLight(lightId);
                }
            }
        }

        System.out.println();
        System.out.println("Building summary:");
        building.printStatus();
    }

    static void printHelp() {
        System.out.println();
        System.out.println("Available commands:");
        System.out.println();
        System.out.println("  status                               - show building status");
        System.out.println();
        System.out.println("  building on|off                      - all lights on/off");
        System.out.println();
        System.out.println("  floor <number> on|off                - all lights on a floor");
        System.out.println();
        System.out.println("  room <floor> <n> on|off              - all lights in a room");
        System.out.println();
        System.out.println("  light <floor> <room> <id> on|off|toggle");
        System.out.println();
        System.out.println("  dim <floor> <room> <id> <brightness 0-100>");
        System.out.println();
        System.out.println("  schedule <floor> <room> <id> <from HH:MM> <until HH:MM>");
        System.out.println();
        System.out.println("  schedule <floor> <room> <id> clear");
        System.out.println();
        System.out.println("  tick <HH:MM>                         - simulate a time");
        System.out.println();
        System.out.println("  help                                 - command list");
        System.out.println();
        System.out.println("  exit");
        System.out.println();
    }
}