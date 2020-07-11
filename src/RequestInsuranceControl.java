public class RequestInsuranceControl {
    private Insurance insurance;
    public RequestInsuranceControl() {}

    public void submitRequest(String insuranceName, String IID) {
        ManageInsuranceControl manageInsuranceControl = ManageInsuranceControl.getInstance();
        InsuranceReply insuranceReply = manageInsuranceControl.submitRequestToInsuranceAPI(insuranceName, IID);
        if (insuranceReply.getStatus())
            insurance = new Insurance(insuranceName, IID, insuranceReply.getFranchise());
        TestRequest.getInstance().setInsurance(insurance);
    }

}
