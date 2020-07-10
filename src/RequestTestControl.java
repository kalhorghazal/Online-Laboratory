import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RequestTestControl {
    private TestRequest testRequest;
    public RequestTestControl() {}

    public void requestTest(String firstName, String lastName, int age, String NID, ArrayList<String> diseases) {
        testRequest = new TestRequest(firstName, lastName, age, NID, diseases);
    }

    public void getTestNames(BufferedImage prescriptionImage) {
        String preID = testRequest.makePrescription(prescriptionImage);
        ManageGetTestNames.getInstance().addToUncheckedPrescription(preID);
    }

    public void sendTestList(ArrayList<String> testNames) {
        for (String testName : testNames) {
            testRequest.makeTest(testName);
        }
    }

    public void getLabList() {
        //TODO: getLabList!
    }

//    sendFilter(filterParams: List params

//    public void submitLab()

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
        // TODO:
    }

    private String selectPhlebotomist() {

    }

    public ArrayList<LocalDateTime> selectTimeSlot() {
        return Laboratory.getInstance().getTimeSlots();
    }

    public void submitTimeSlot(LocalDateTime timeSlot) {
        testRequest.makeAppointment(timeSlot.toLocalDate(), timeSlot.toLocalTime());
    }
}
