import java.time.LocalDateTime;
import java.util.ArrayList;

public class Laboratory {
    private String name;
    private Place place;
    private ArrayList<String> supportedInsuranceList;
    private String ID;
    public Laboratory(String _name, String _address,
                      ArrayList<String> _supportedInsuranceList, String _ID) {
        name = _name;
        place = new Place(_address);
        supportedInsuranceList = _supportedInsuranceList;
        ID = _ID;
    }

    public ArrayList<LocalDateTime> getTimeSlots() {
        return new ArrayList<>();
    }

    public boolean supportInsurance(String insuranceName) {
        return supportedInsuranceList.contains(insuranceName);
    }

    public String getID() {
        return ID;
    }

}
