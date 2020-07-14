public class Insurance {
    private String name;
    private String ID;
    private float franchise;
    private boolean isEnabled;
    public Insurance(String _name, String _ID, float _franchise) {
        name = _name;
        ID = _ID;
        franchise = _franchise;
        isEnabled = false;
    }
    public float getFranchise() { return franchise; }
    public String getName() { return name; }
    public String getID() { return ID; }
    public boolean isEnabled() { return isEnabled; }
    public void enable() {
        isEnabled = true;
    }
}
