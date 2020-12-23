package week09.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SantaClaus {
    List<Person> people;

    public SantaClaus(List<Person> people) {
        if (people == null) {
            throw new IllegalArgumentException("Nobody in people!");
        }
        for (Person person : people) {
            if (person == null) {
                throw new IllegalArgumentException("Somebody is null!");
            }
        }
        this.people = people;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public void getThroughChimneys() {
        for (Person person : people) {
            person.setPresent();
        }
    }

    public static void main(String[] args) {
        SantaClaus santaClaus = new SantaClaus(Arrays.asList(
                new Person("Bela", 13),
                new Person("Jozsi", 23),
                new Person("Andi", 3),
                new Person("Juli", 33)));
        for (int i = 0; i < 10; i++) {
            santaClaus.getThroughChimneys();
            System.out.println(santaClaus.getPeople());
        }
    }
}
