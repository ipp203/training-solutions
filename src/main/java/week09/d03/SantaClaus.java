package week09.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SantaClaus {
    List<Person> persons;

    public SantaClaus(List<Person> persons) {
        if (persons == null) {
            throw new IllegalArgumentException("Nobody in persons!");
        }
        for (Person person : persons) {
            if (person == null) {
                throw new IllegalArgumentException("Somebody is null!");
            }
        }
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public void getThroughChimneys() {
        for (Person person : persons) {
            person.setPresent();
        }
    }

    public static void main(String[] args) {
        SantaClaus santaClaus = new SantaClaus(Arrays.asList(
                new Person("Bela", 13),
                new Person("Jozsi", 33),
                new Person("Andi", 23),
                new Person("Juli", 93)));
        santaClaus.getThroughChimneys();

        System.out.println(santaClaus.getPersons());
    }
}
