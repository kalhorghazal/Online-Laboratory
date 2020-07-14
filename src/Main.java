import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<Laboratory> laboratories;
    private static ArrayList<Phlebotomist> phlebotomists;
    private static HashMap<String, Float> testPrices;
    public static ArrayList<Laboratory> getLaboratories() {
        return  laboratories;
    }

    public static ArrayList<Phlebotomist> getPhlebotomists() {
        return phlebotomists;
    }

    public static HashMap<String, Float> getTestPrices() {
        return testPrices;
    }

    public static Laboratory findLabByID(String LID) {
        for (Laboratory lab : laboratories) {
            if (lab.getID().equals(LID)) {
                return lab;
            }
        }
        return null;
    }

    public static Phlebotomist findPhlebotomistByID(String phID) {
        for (Phlebotomist phlebotomist : phlebotomists) {
            if (phlebotomist.getPhID().equals(phID)) {
                return phlebotomist;
            }
        }
        return null;
    }

    public static void init() {
        String phID = Integer.toString(Tracker.nextPhID);
        Tracker.setNextPhID();
        Phlebotomist newPh = new Phlebotomist(phID);

        String LID = Integer.toString(Tracker.nextLID);
        Tracker.setNextLID();
        Phlebotomist newLab = new Laboratory(name, address, insurances, LID);

    }
    public static void main() {

    }
}
