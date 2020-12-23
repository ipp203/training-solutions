package week09.d03;

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

    public void getThroughChimneys() {
        for (Person person : persons) {
            person.setPresent();
        }
    }
}
