package es131125;

import java.util.*;

public class ReservationSystem {
    private List<Flight> fs;
    private List<Reservation> rs;

    public ReservationSystem() {
        fs = new ArrayList<>();
        rs = new ArrayList<>();
    }

    public void addF(Flight f) {
        fs.add(f);
    }

    public void addRes(Reservation reservation) {
        rs.add(reservation);
    }

    public Flight findFC(String code) {
        for (Flight f : fs) {
            if (f.getC().equalsIgnoreCase(code)) {
                return f;
            }
        }
        return null;
    }

    public Reservation findRId(String id) {
        for (Reservation r : rs) {
            if (r.getId().equalsIgnoreCase(id)) {
                return r;
            }
        }
        return null;
    }

    public void pF() {
        System.out.println("\nElenco voli disponibili:");
        for (Flight f : fs) {
            System.out.println(f);
        }
    }

    public void pRes() {
        System.out.println("\n📋 Elenco prenotazioni:");
        for (Reservation r : rs) {
            System.out.println(r);
        }
    }
}
