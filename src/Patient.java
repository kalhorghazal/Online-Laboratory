import java.util.ArrayList;

public class Patient extends User {
    private ArrayList<TestRequest> testRequests;
    public Patient(String _firstName, String _lastName, String _userName, String _password) {
        super(_firstName, _lastName, _userName, _password);
        testRequests = new ArrayList<>();
    }

    public void addTestRequest(TestRequest testRequest) {
        testRequests.add(testRequest);
    }
}
