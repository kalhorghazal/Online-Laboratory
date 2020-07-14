import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<Laboratory> laboratories;
    private static ArrayList<Phlebotomist> phlebotomists;
    private static HashMap<String, Float> testPrices;
    private static ArrayList<User> users;
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
        phlebotomists = new ArrayList<>();
        laboratories = new ArrayList<>();
        users = new ArrayList<>();
        String phID1 = Integer.toString(Tracker.nextPhID);
        Tracker.setNextPhID();
        Phlebotomist newPh1 = new Phlebotomist(phID1, "Arman", "Armani",
                "armanarmani", "1234");
        phlebotomists.add(newPh1);
        users.add(newPh1);

        String phID2 = Integer.toString(Tracker.nextPhID);
        Tracker.setNextPhID();
        Phlebotomist newPh2 = new Phlebotomist(phID2, "Mahsa", "Mahani",
                "mahsamahani", "5678");
        phlebotomists.add(newPh2);
        users.add(newPh2);

        String LID1 = Integer.toString(Tracker.nextLID);
        Tracker.setNextLID();
        String name1 = "Arya";
        String address1 = "32, Enghelab Sq., Tehran, Tehran";
        ArrayList<String> insurances1 = new ArrayList<>();
        insurances1.add("Moallem");
        insurances1.add("Takmili");
        insurances1.add("Asia");
        Laboratory newLab1 = new Laboratory(name1, address1, insurances1, LID1);
        laboratories.add(newLab1);

        String LID2 = Integer.toString(Tracker.nextLID);
        Tracker.setNextLID();
        String name2 = "Takhasosi Fardis";
        String address2 = "35, 15th Street, Fardis, Alborz";
        ArrayList<String> insurances2 = new ArrayList<>();
        insurances2.add("Tamin Ejtemaei");
        insurances2.add("Takmili");
        insurances2.add("Khadamat Darmani");
        insurances2.add("Saman");
        insurances2.add("Iran");
        Laboratory newLab2 = new Laboratory(name2, address2, insurances2, LID2);
        laboratories.add(newLab2);

        String LID3 = Integer.toString(Tracker.nextLID);
        Tracker.setNextLID();
        String name3 = "Noor";
        String address3 = "93, Kargar Boulevard, Tehran, Tehran";
        ArrayList<String> insurances3 = new ArrayList<>();
        insurances3.add("Saman");
        insurances3.add("Iran");
        insurances3.add("Sina");
        insurances3.add("Moallem");
        Laboratory newLab3 = new Laboratory(name3, address3, insurances3, LID3);
        laboratories.add(newLab3);

        Patient patient = new Patient("Borna", "Bordbar",
                "bornabb", "2222");
        users.add(patient);
    }
    public static void main() {

    }
}
