import java.time.LocalDateTime;
import java.util.ArrayList;

public class Laboratory {
    private String name;
    private Place place;
    private ArrayList<String> supportedInsuranceList;
    private String ID;
    private ArrayList<LocalDateTime> timeSlots;
    public Laboratory(String _name, String _address,
                      ArrayList<String> _supportedInsuranceList, String _ID,
                      ArrayList<LocalDateTime> _timeSlots) {
        name = _name;
        place = new Place(_address);
        supportedInsuranceList = _supportedInsuranceList;
        ID = _ID;
        timeSlots = _timeSlots;
    }

    public ArrayList<LocalDateTime> getTimeSlots() {
        return timeSlots;
    }

    public boolean supportInsurance(String insuranceName) {
        return supportedInsuranceList.contains(insuranceName);
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        String str = name + " Laboratory, ID: " + ID + "\n-----------------------" +
                "\nSupported insurances: ";
        str += String.join(", ", supportedInsuranceList);
        return str + "\n";
    }
}
