package es26022026;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient p = null;

        System.out.println("=== SISTEMA OSPEDALIERO INTERATTIVO ===");

        while (true) {
            try {
                System.out.println("\n1. Registra Paziente | 2. Parametri Vitali | 3. Chirurgia | 4. Esci");
                System.out.print("Scelta: ");
                int s = Integer.parseInt(sc.nextLine());

                switch (s) {
                    case 1:
                        System.out.print("Nome: "); String n = sc.nextLine();
                        System.out.print("CF (16 car): "); String cf = sc.nextLine();
                        System.out.print("Età: "); int age = Integer.parseInt(sc.nextLine());
                        p = new Patient(cf, n, age);
                        System.out.println("Paziente registrato!");
                        break;

                    case 2:
                        if (p == null) throw new IllegalStateException("Registra prima un paziente!");
                        System.out.print("Temp: "); double t = Double.parseDouble(sc.nextLine());
                        System.out.print("BPM: "); int bpm = Integer.parseInt(sc.nextLine());
                        System.out.print("SpO2: "); int o2 = Integer.parseInt(sc.nextLine());
                        p.lifeParamRec(t, bpm, o2);
                        break;

                    case 3:
                        if (p == null) throw new IllegalStateException("Registra prima un paziente!");
                        Surgeon chirurgo = new Surgeon("Rossi", 13);
                        chirurgo.startOperation(p);
                        break;

                    case 4:
                        System.out.println("Chiusura sistema...");
                        return;

                    default:
                        System.out.println("Scelta non valida.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Errore: Inserire un numero valido!");
            } catch (DataExc | LifeParamExc e) {
                System.err.println("ERRORE CLINICO/DATI: " + e.getMessage());
                if (e instanceof LifeParamExc && ((LifeParamExc) e).isEmergency()) 
                    System.err.println("ATTENZIONE: EMERGENZA CODICE ROSSO!");
            } catch (Exception e) {
                System.err.println("ERRORE DI SISTEMA: " + e.getMessage());
            } finally {
                System.out.println("[Operazione conclusa]");
            }
        sc.close();
        }
    }
}