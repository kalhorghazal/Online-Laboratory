import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class Phlebotomist extends User {
    private String phID;
    private String firstName;
    private String lastName;
    private ArrayList<LocalDateTime> submittedTimeSlots;
    public Phlebotomist(String _phID, String _firstName, String _lastName,
                        String _username, String _password) {
        super(_firstName, _lastName, _username, _password);
        phID = _phID;
        submittedTimeSlots = new ArrayList<>();
    }

    public boolean isAvailable(LocalDateTime timeSlot) {
        for (LocalDateTime dateTime : submittedTimeSlots) {
            if (Math.abs(dateTime.atZone(ZoneId.systemDefault()).toEpochSecond()
                    - timeSlot.atZone(ZoneId.systemDefault()).toEpochSecond()) < 3600) {
                return false;
            }
        }
        return true;
    }

    public void submitTimeSlot(LocalDateTime timeSlot) {
        submittedTimeSlots.add(timeSlot);
    }

    public String getPhID() {
        return phID;
    }

    public void printTimeSlots() {
        for (LocalDateTime localDateTime : submittedTimeSlots) {
            System.out.println(localDateTime);
        }
    }
}
