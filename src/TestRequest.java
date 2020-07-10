import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TestRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String NID;
    private ArrayList<String> diseases;
    private Prescription prescription;
    private ArrayList<Test> tests;
    private Appointment appointment;
    private Sampling sampling;
    private Place place;
    public TestRequest(String _firstName, String _lastName, int _age, String _NID, ArrayList<String> _diseases) {
        firstName = _firstName;
        lastName = _lastName;
        age = _age;
        NID = _NID;
        diseases = _diseases;
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNID() {
        return NID;
    }

    public ArrayList<String> getDiseases() {
        return diseases;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public String makePrescription(BufferedImage prescriptionImage) {
        int currentID = Tracker.nextPreID;
        prescription = new Prescription(Integer.toString(currentID), prescriptionImage);
        Tracker.setNextPreID();
        return Integer.toString(currentID);
    }

    public void makeTest(String testName) {
        Test test = new Test(testName);
        tests.add(test);
    }

    public void makeAppointment(LocalDate date, LocalTime time) {
        appointment = new Appointment(date, time);
    }

    public void makeSampling() {
        // TODO: sampling!
        sampling = new Sampling();
    }

    public void makePlace(String address) {
        place = new Place(address);
    }
}
