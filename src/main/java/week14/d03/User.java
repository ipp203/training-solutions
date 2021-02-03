package week14.d03;

public class User {
    private final String name;
    private final int age;
    private final String address;

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + '(' + age + ')'+
                ", address= " + address;
    }
}
