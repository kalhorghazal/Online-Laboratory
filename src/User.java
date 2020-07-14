public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    public User(String _firstName, String _lastName, String _userName, String _password) {
        firstName = _firstName;
        lastName = _lastName;
        userName = _userName;
        password = _password;
    }

    public boolean authenticate(String _password) {
        return password.equals(_password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
