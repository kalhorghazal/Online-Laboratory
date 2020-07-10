import java.time.LocalDateTime;
import java.util.ArrayList;

public class Laboratory {
    private static final Laboratory instance = new Laboratory();
    private Laboratory() {}
    public static Laboratory getInstance() {
        return instance;
    }
    public ArrayList<LocalDateTime> getTimeSlots() {

    }
}
