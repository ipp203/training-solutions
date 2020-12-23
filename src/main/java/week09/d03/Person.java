package week09.d03;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    private Present present;

    public Person(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age is abnormal");
        }
        this.name = name;
        this.age = age;
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent() {
        Random rnd = new Random();
        if (age <= 14) {
            present = Present.values()[rnd.nextInt(Present.values().length)];
        } else {
            present = Present.values()[rnd.nextInt(Present.values().length - 1) + 1];
        }
    }

    @Override
    public String toString() {
        return name + ": " + present.getName() + " (" + age + ")'";
    }
}
