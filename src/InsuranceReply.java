public class InsuranceReply {
    private boolean status;
    private float franchise;
    public InsuranceReply(boolean _status, float _franchise) {
        status = _status;
        franchise = _franchise;
    }

    @Override
    public String toString() {
        return "status: " + (status ? "OK" : "ERROR");
    }

    public float getFranchise() { return franchise; }
    public boolean getStatus() { return status; }
}
