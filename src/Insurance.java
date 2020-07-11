public class Insurance {
    private String name;
    private String ID;
    private double franchise;
    public Insurance(String _name, String _ID, double _franchise) {
        name = _name;
        ID = _ID;
        franchise = _franchise;
    }
    public double getFranchise() { return franchise; }
    public String getName() { return name; }
    public String getID() { return ID; }
}
