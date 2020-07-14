import java.time.LocalDateTime;
import java.util.ArrayList;

public class RequestTestControl {
    private TestRequest testRequest;
    public RequestTestControl() {}

    public void requestTest(String firstName, String lastName, int age, String NID, ArrayList<String> diseases) {
        testRequest = new TestRequest(firstName, lastName, age, NID, diseases);
    }

    public void sendTestList(ArrayList<String> testNames) {
        testRequest.makeSampling();
        for (String testName : testNames) {
            testRequest.makeTest(testName);
        }
    }

    public ArrayList<Laboratory> selectLab() {
        String insuranceName = testRequest.getInsuranceName();
        ArrayList<Laboratory> supportingLabs = new ArrayList<>();
        for (Laboratory lab : Main.getLaboratories()) {
            if (lab.supportInsurance(insuranceName)) {
                supportingLabs.add(lab);
            }
        }
        return supportingLabs;
    }

//    sendFilter(filterParams: List params

    public void submitLab(String LID) {
        testRequest.setLab(LID);
        Laboratory selectedLab = Main.findLabByID(LID);
        if ((selectedLab != null)
            && (selectedLab.supportInsurance(testRequest.getInsuranceName()))) {
                testRequest.enableInsurance();
            }
    }

    public void sendAddress(String address) {
        boolean isAddressOK = ManageSendAddress.getInstance().submitAddressToGPS(address);
        if (isAddressOK) {
            testRequest.makePlace(address);
        } else {
            System.out.println("Error, Address is not valid!");
        }
    }

    public void allocatePhlebotomist() {
        String phID = selectPhlebotomist();
        if (phID == null) {
            System.out.println("Error, no phlebotomist available for this date and time!");
        } else {
            testRequest.setPhlebotomist(phID);
            Phlebotomist ph = Main.findPhlebotomistByID(phID);
            if (ph != null)
                ph.submitTimeSlot(testRequest.getDateTime());
        }
    }

    private String selectPhlebotomist() {
        for (Phlebotomist ph : Main.getPhlebotomists()) {
            if (ph.isAvailable(testRequest.getDateTime()))
                return ph.getPhID();
        }
        return null;
    }

    public ArrayList<LocalDateTime> selectTimeSlot() {
        String LID = testRequest.getLabID();
        Laboratory lab = Main.findLabByID(LID);
        ArrayList<LocalDateTime> timeSlots = null;
        if (lab != null)
            timeSlots = lab.getTimeSlots();
        return timeSlots;
    }

    public void submitTimeSlot(LocalDateTime timeSlot) {
        testRequest.makeAppointment(timeSlot);
    }


}
