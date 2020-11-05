package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Billy Joe","015145BA");
        person.moveTo(new Address("Hungary","Budapest","Billy str 75.","1234"));

        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        person.correctData("Billy John","BA015145");
        person.getAddress().correctData(person.getAddress().getCountry(),
                person.getAddress().getCity(),person.getAddress().getStreetAndNumber(),
                "2345");
        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());
    }
}
