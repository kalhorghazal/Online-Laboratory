public class ManageSendAddress {
    private static final ManageSendAddress instance = new ManageSendAddress();
    private ManageSendAddress() {}
    public static ManageSendAddress getInstance() {
        return instance;
    }

    public boolean submitAddressToGPS(String address) {
        // GPS API Call Should be here
        return true;
    }
}
