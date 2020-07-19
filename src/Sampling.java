import java.util.ArrayList;

public class Sampling {
    private String phID;
    private Place place;
    private ArrayList<Test> tests;
    public Sampling() {
        tests = new ArrayList<>();
    }

    public void makePlace(String address) {
        place = new Place(address);
    }

    public void setPhlebotomist(String _phID) {
        phID = _phID;
    }

    public void makeTest(String testName, float testPrice) {
        Test newTest = new Test(testName, testPrice);
        tests.add(newTest);
    }

    public String getPhID() {
        return phID;
    }
}
