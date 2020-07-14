public class RequestInsuranceControl {
    private static final RequestInsuranceControl instance = new RequestInsuranceControl();
    private RequestInsuranceControl() { }
    public static RequestInsuranceControl getInstance() {
        return instance;
    }

    public InsuranceReply submitRequestToInsuranceAPI(String insuranceName, String IID) {
        // Insurance API call should be here
        return new InsuranceReply(true, 0.1f);
    }
}
