import java.time.LocalDateTime;

public class Appointment {
    private LocalDateTime dateTime;
    public Appointment(LocalDateTime _dateTime) {
        dateTime = _dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
