public class Phlebotomist {
    private String phID;
    public Phlebotomist() {
        phID = Integer.toString(Tracker.nextPhID);
        Tracker.setNextPhID();
    }
}
