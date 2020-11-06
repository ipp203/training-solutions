package references.parameters;

public class ReferenceMain {
    public static void main(String[] args) {
        Person person1;
        Person person2;
        Person person3 = new Person("Tivadar", 44);

        person1 = person3;
        person2 = person1;

        person2.setName("Peter");

        System.out.println(person1.getName() + " " + person2.getName() + " " + person3.getName());

        int a, b;
        a = 24;
        b = a;
        b++;

        System.out.println(a + ", " + b);

        Person person4 = new Person("Pal", 33);

        person1 = person4;

        System.out.println(person1.getName() + " " + person4.getName());

    }
}
