public class RequestPaymentControl {
    private static final RequestPaymentControl instance = new RequestPaymentControl();
    private RequestPaymentControl() { }
    public static RequestPaymentControl getInstance() {
        return instance;
    }

    public void submitPriceToOnlineBanking(float price) {
        // Online Banking API call should be here
    }

    public boolean redirectToToOnlineBanking() {
        // Online Banking API call should be here
        return true;
    }

}
