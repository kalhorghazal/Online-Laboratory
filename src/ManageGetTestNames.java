import java.util.ArrayList;

public class ManageGetTestNames {
    private static final ManageGetTestNames instance = new ManageGetTestNames();
    private ManageGetTestNames() {}
    public static ManageGetTestNames getInstance() {
        return instance;
    }
    private ArrayList<String> uncheckedPrescriptions = new ArrayList<>();
    public void addToUncheckedPrescription(String preId) {
        uncheckedPrescriptions.add(preId);
    }
    public void checkPrescription(String preID) {
        uncheckedPrescriptions.remove(preID);
    }
}
