import java.util.ArrayList;

public class Patient extends User {
    private ArrayList<TestRequest> testRequests;
    private int age;
    private String NID;
    private ArrayList<String> diseases;
    public Patient(String _firstName, String _lastName, String _NID,
                   int _age, ArrayList<String> _diseases,
                   String _userName, String _password) {
        super(_firstName, _lastName, _userName, _password);
        testRequests = new ArrayList<>();
        age = _age;
        diseases = _diseases;
        NID = _NID;
    }

    public void addTestRequest(TestRequest testRequest) {
        testRequests.add(testRequest);
    }

    public String getNID() {
        return NID;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getDiseases() {
        return diseases;
    }
}
