package exam03retake01;

public class Contact {

    private String name;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public boolean contains(String nameOrEmail) {
        return name.equals(nameOrEmail) || email.equals(nameOrEmail);
    }
}
