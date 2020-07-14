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
        if (insuranceName == null) {
            return Main.getLaboratories();
        }
        ArrayList<Laboratory> supportingLabs = new ArrayList<>();
        for (Laboratory lab : Main.getLaboratories()) {
            if (lab.supportInsurance(insuranceName)) {
                supportingLabs.add(lab);
            }
        }
        return supportingLabs;
    }

//    sendFilter(filterParams: List params)

    public void submitLab(String LID) {
        testRequest.setLab(LID);
        Laboratory selectedLab = Main.findLabByID(LID);
        if ((testRequest.getInsuranceName() != null) && (selectedLab != null)
            && (selectedLab.supportInsurance(testRequest.getInsuranceName()))) {
                testRequest.enableInsurance();
            }
    }

    public void sendAddress(String address) {
        boolean isAddressOK = ManageSendAddress.getInstance().submitAddressToGPS(address);
        if (isAddressOK) {
            testRequest.submitAddress(address);
        } else {
            System.out.println("Error, address is not valid!");
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

    public void requestInsurance(String IID, String insuranceName) {
        InsuranceReply insuranceReply = RequestInsuranceControl.getInstance().submitRequestToInsuranceAPI(insuranceName, IID);
        if (!insuranceReply.getStatus()) {
            System.out.println("Error, insurance is not valid!");
            return;
        }
        System.out.println(insuranceReply);
        testRequest.makeInsurance(insuranceName, IID, insuranceReply.getFranchise());
    }

    public void requestPayment() {
        float totalPrice = testRequest.getTotalPrice();
        System.out.println("Total price: " + totalPrice);
        RequestPaymentControl.getInstance().submitPriceToOnlineBanking(totalPrice);
        boolean wasPaymentOk = RequestPaymentControl.getInstance().redirectToToOnlineBanking();
        if (!wasPaymentOk) {
            System.out.println("Error, payment has not been proceeded");
        }
    }

    public TestRequest getTestRequest() {
        return testRequest;
    }
}
