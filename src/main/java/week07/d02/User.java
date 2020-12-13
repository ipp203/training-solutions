package week07.d02;

public interface User {
    String getUsername();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

/*    static User of(String userName, String firstName, String lastName) {
        return new UserImpl(userName, firstName, lastName);
    }*/

    static User of(String userName, String firstName, String lastName) {
        return new User() {//anonymous innerclass
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
        };
    }


}
