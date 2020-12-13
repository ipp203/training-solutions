package week03.d04;

public class PhoneParser {
    public Phone parse(String str) {
        String[] data = str.split("-");

        return new Phone(data[0], data[1]);
    }

    public static void main(String[] args) {
        PhoneParser phoneParser = new PhoneParser();
        Phone phone = phoneParser.parse("10-1234567");
        System.out.println(phone.getPrefix());
        System.out.println(phone.getNumber());
    }
}
