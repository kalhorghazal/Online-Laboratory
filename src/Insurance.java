public class Insurance {
    private String name;
    private String ID;
    private double franchise;
    private boolean isEnabled;
    public Insurance(String _name, String _ID, double _franchise) {
        name = _name;
        ID = _ID;
        franchise = _franchise;
        isEnabled = false;
    }
    public double getFranchise() { return franchise; }
    public String getName() { return name; }
    public String getID() { return ID; }
    public boolean isEnabled() { return isEnabled; }
    public void enable() {
        isEnabled = true;
    }
}
