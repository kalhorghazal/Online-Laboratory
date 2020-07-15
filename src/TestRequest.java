import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String NID;
    private ArrayList<String> diseases;
    private String labID;
    private float totalPrice;
    private Appointment appointment;
    private Sampling sampling;
    private Insurance insurance;
    public TestRequest(String _firstName, String _lastName, int _age, String _NID, ArrayList<String> _diseases) {
        firstName = _firstName;
        lastName = _lastName;
        age = _age;
        NID = _NID;
        diseases = _diseases;
        totalPrice = 0;
    }

    public void makeTest(String testName) {
        float testPrice = getTestPrice(testName);
        sampling.makeTest(testName, testPrice);
        addToTotalPrice(testPrice);
    }

    public void makeAppointment(LocalDateTime timeSlot) {
        appointment = new Appointment(timeSlot);
    }

    public void makeSampling() {
        sampling = new Sampling();
    }

    public void setLab(String LID) {
        labID = LID;
    }

    public float getTestPrice(String testName) {
        return Main.getTestPrices().get(testName);
    }

    public void addToTotalPrice(float price) {
        totalPrice += price;
    }

    public String getInsuranceName() {
        if (insurance == null)
            return null;
        return insurance.getName();
    }

    public void enableInsurance() {
        insurance.enable();
    }

    public void submitAddress(String address) {
        sampling.makePlace(address);
    }

    public String getLabID() { return labID; }

    public LocalDateTime getDateTime() {
        return appointment.getDateTime();
    }

    public void setPhlebotomist(String phID) {
        sampling.setPhlebotomist(phID);
    }

    public void makeInsurance(String insuranceName, String IID, float franchise) {
        insurance = new Insurance(insuranceName, IID, franchise);
    }

    public float getTotalPrice() {
        float franchise;
        if (insurance != null && insurance.isEnabled()) {
            franchise = insurance.getFranchise();
            applyFranchise(franchise);
        }
        return totalPrice;
    }

    public void applyFranchise(float franchise) {
        totalPrice *= franchise;
    }
}
