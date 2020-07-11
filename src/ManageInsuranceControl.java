public class ManageInsuranceControl {
    private static final ManageInsuranceControl instance = new ManageInsuranceControl();
    private ManageInsuranceControl() { }
    public static ManageInsuranceControl getInstance() {
        return instance;
    }
    public InsuranceReply submitRequestToInsuranceAPI(String insuranceName, String IID) {
        // Insurance API call should be here
        return new InsuranceReply(true, 0.1);
    }
}
