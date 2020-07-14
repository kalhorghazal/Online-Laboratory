import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

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
        testPrices = new HashMap<>();

        Patient patient = new Patient("Borna", "Bordbar",
                "0022211918", 21, null, "bornabb", "2222");
        users.add(patient);

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
        ArrayList<LocalDateTime> timeSlots1 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            LocalDateTime timeSlot = LocalDateTime.of(2020, 7, 16,
                    8 + i, 0);
            timeSlots1.add(timeSlot);
        }
        Laboratory newLab1 = new Laboratory(name1, address1, insurances1, LID1, timeSlots1);
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
        ArrayList<LocalDateTime> timeSlots2 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDateTime timeSlot = LocalDateTime.of(2020, 7, 15,
                    9 + i, 0);
            timeSlots2.add(timeSlot);
        }
        Laboratory newLab2 = new Laboratory(name2, address2, insurances2, LID2, timeSlots2);
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
        ArrayList<LocalDateTime> timeSlots3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LocalDateTime timeSlot = LocalDateTime.of(2020, 7, 14,
                    8 + i, 0);
            timeSlots3.add(timeSlot);
        }
        Laboratory newLab3 = new Laboratory(name3, address3, insurances3, LID3, timeSlots3);
        laboratories.add(newLab3);

        testPrices.put("FBS", 20000f);
        testPrices.put("HDL", 5000f);
        testPrices.put("LDL", 5000f);
        testPrices.put("CBC", 10000f);
        testPrices.put("RBC", 8500f);
        testPrices.put("BUN", 40000f);
        testPrices.put("Calcium", 6500f);
    }

    public static boolean areTestNamesValid(ArrayList<String> testNames) {
        for (String testName : testNames) {
            if (!testPrices.containsKey(testName)) {
                return false;
            }
        }
        return true;
    }

    public static void requestTest() {
        RequestTestControl requestTestControl = new RequestTestControl();

        Patient patient = (Patient) users.get(0);
        requestTestControl.requestTest(patient.getFirstName(), patient.getLastName(),
                patient.getAge(), patient.getNID(), patient.getDiseases());

        System.out.println("Please enter test names separated by comma:");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> testNames = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        while (testNames.size() == 0) {
            System.out.println("Error, test names can not be empty!\n" +
                    "Please enter test names separated by comma:");
            testNames = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        }
        while (!areTestNamesValid(testNames)) {
            System.out.println("Error, test names are not valid!\n" +
                    "Please enter test names separated by comma:");
            testNames = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        }
        requestTestControl.sendTestList(testNames);

        System.out.println("Please enter your insurance ID: (leave empty if none exists)");
        String insuranceID = scanner.nextLine();
        if (!insuranceID.equals("")) {
            System.out.println("Please enter your insurance name:");
            String insuranceName = scanner.nextLine();
            requestTestControl.requestInsurance(insuranceID, insuranceName);
        }

        ArrayList<Laboratory> labs = requestTestControl.selectLab();
        for (Laboratory lab : labs) {
            System.out.println(lab);
        }
        System.out.println("Please enter selected lab id: ");
        String LID = scanner.nextLine();
        while (findLabByID(LID) == null) {
            System.out.println("Error, selected lab id is not valid!\n" +
                    "Please enter selected lab id:");
            LID = scanner.nextLine();
        }
        requestTestControl.submitLab(LID);

        System.out.println("Available time slots:");
        ArrayList<LocalDateTime> timeSlots = requestTestControl.selectTimeSlot();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (int i = 0; i < timeSlots.size(); i++) {
            System.out.println(i + ". " + timeSlots.get(i).format(formatter));
        }
        System.out.println("Please enter selected time slot index:");
        int index = scanner.nextInt();
        while (index >= timeSlots.size()) {
            System.out.println("Error, selected time slot index is not valid!\n" +
                    "Please enter selected time slot index:");
            index = scanner.nextInt();
        }
        requestTestControl.submitTimeSlot(timeSlots.get(index));

        System.out.println("Please enter your address:");
        String address = scanner.nextLine();
        requestTestControl.sendAddress(address);
        requestTestControl.requestPayment();
        requestTestControl.allocatePhlebotomist();
    }

    public static void main(String[] args) {
        init();
        requestTest();
    }
}
