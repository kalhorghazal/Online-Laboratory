import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class Phlebotomist {
    private String phID;
    private ArrayList<LocalDateTime> submittedTimeSlots;
    public Phlebotomist(String _phID) {
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

    public void setTimeSlot(LocalDateTime timeSlot) {
        submittedTimeSlots.add(timeSlot);
    }

    public String getPhID() {
        return phID;
    }
}
