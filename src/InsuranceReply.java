public class InsuranceReply {
    private boolean status;
    private double franchise;
    public InsuranceReply(boolean _status, double _franchise) {
        status = _status;
        franchise = _franchise;
    }

    @Override
    public String toString() {
        return "status: " + (status ? "OK" : "ERROR");
    }

    public double getFranchise() { return franchise; }
    public boolean getStatus() { return status; }
}
