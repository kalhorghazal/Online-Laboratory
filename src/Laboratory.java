import java.time.LocalDateTime;
import java.util.ArrayList;

public class Laboratory {
    private String name;
    private Place place;
    public Laboratory(String _name, String _address) {
        name = _name;
        place = new Place(_address);
    }

    public ArrayList<LocalDateTime> getTimeSlots() {
        return new ArrayList<>();
    }

}
