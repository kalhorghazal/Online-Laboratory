import java.awt.image.BufferedImage;

public class Prescription {
    private String prescriptionID;
    private BufferedImage prescriptionImage;
    public Prescription(String _prescriptionID, BufferedImage _prescriptionImage) {
        prescriptionID = _prescriptionID;
        prescriptionImage = _prescriptionImage;
    }
}
