package week07.d02;

public class UserImpl implements User {
    private String userName;
    private String firstName;
    private String lastName;

    public UserImpl(String userName, String firstName, String lastName) {
        if (isEmpty(userName) || isEmpty(firstName) || isEmpty(lastName)) {
            throw new IllegalArgumentException("One or more names are empty.");
        }
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
