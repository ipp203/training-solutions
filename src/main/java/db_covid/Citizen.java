package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.time.LocalDate;
import java.util.Objects;

public class Citizen {
    private static final int MIN_AGE = 10;
    private static final int MAX_AGE = 150;
    private static final String EMAIL_AT = "@";
    private static final int SSN_LENGTH = 9;

    public static final String THANK_YOU = "Köszönöm.";
    public static final LocalDate DEFAULT_DATE = LocalDate.of(1980, 1, 1);

    private int citizenId;
    private final String name;
    private final String email;
    private final int age;
    private final String zipCode;
    private final String socialSecurityNumber;
    private int numberOfVaccination;
    private LocalDate lastVaccination;

    public Citizen(String name, String email, int age, String zipCode, String socialSecurityNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.zipCode = zipCode;
        this.socialSecurityNumber = socialSecurityNumber;
        numberOfVaccination = 0;
        lastVaccination = null;
        citizenId = 0;
    }

    public Citizen(int id, String name, String email, int age, String zipCode, String socialSecurityNumber, int numberOfVaccination, LocalDate lastVaccination) {
        this(name, email, age, zipCode, socialSecurityNumber);
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccination = lastVaccination;
        citizenId = id;
    }

    public int getId() {
        return citizenId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDate getLastVaccination() {
        return lastVaccination;
    }

    public static BoolString isNameValid(String name) {
        if (name == null || name.isBlank()) {
            return new BoolString(false, "A név üres. Adja meg újra!");
        }
        return new BoolString(true, THANK_YOU);
    }

    public static BoolString isZipCodeValid(String zipCode, MariaDbDataSource dataSource) {
        if (zipCode == null || zipCode.isBlank()) {
            return new BoolString(false, "Az irányítószám üres. Adja meg újra!");
        } else {
            String city;
            try {
                city = new ZipCodeDao(dataSource).getCityByZipCode(zipCode);
            } catch (IllegalStateException ise) {
                return new BoolString(false, "Az irányítószám nem létezik. Adja meg újra!");
            }
            return new BoolString(true, THANK_YOU + " Az ön települése " + city);
        }
    }

    public static BoolString isAgeValid(int age) {
        if (age > MIN_AGE && age < MAX_AGE) {
            return new BoolString(true, THANK_YOU);
        }
        return new BoolString(false, String.format("Nem megfelelő életkor (%d<életkor<%d)", MIN_AGE, MAX_AGE));
    }

    public static BoolString isEmailValid(String email) {
        if (email == null || email.length() < 3 || !email.contains(EMAIL_AT)) {
            return new BoolString(false, "E-mail nem érvényes. Adja meg újra!");
        }
        return new BoolString(true, THANK_YOU);
    }

    public static BoolString isEmailEqual(String oldEmail, String newEmail) {
        if (oldEmail.equals(newEmail)) {
            return new BoolString(true, THANK_YOU);
        }
        return new BoolString(false, "Nem egyező e-mail cím. Adja meg újra");
    }

    public static BoolString isSocialSecurityNumberValid(String socialSecurityNumber) {
        BoolString wrongResult = new BoolString(false, "Hibás TAJ szám, csak 9 számot írjon be! Adja meg újra!");
        if (socialSecurityNumber.length() != SSN_LENGTH) {
            return wrongResult;
        }

        char[] numbers = socialSecurityNumber.toCharArray();
        int cdv = Character.getNumericValue(numbers[SSN_LENGTH - 1]);

        int sum = 0;
        for (int i = 0; i < SSN_LENGTH - 1; i++) {
            if (Character.isDigit(numbers[i])) {
                sum = addToSum(numbers[i], sum, i);
            } else {
                return wrongResult;
            }
        }

        if (sum % 10 == cdv) {
            return new BoolString(true, THANK_YOU);
        }
        return wrongResult;
    }

    private static int addToSum(char number, int sum, int i) {
        int c = Character.getNumericValue(number);
        if (i % 2 == 0) {
            sum += c * 3;
        } else {
            sum += c * 7;
        }
        return sum;
    }

    public static boolean isCitizenValid(Citizen citizen, MariaDbDataSource dataSource) {
        return Citizen.isNameValid(citizen.name).getQual() &&
                Citizen.isAgeValid(citizen.age).getQual() &&
                Citizen.isEmailValid(citizen.email).getQual() &&
                Citizen.isZipCodeValid(citizen.zipCode, dataSource).getQual() &&
                Citizen.isSocialSecurityNumberValid(citizen.socialSecurityNumber).getQual();
    }

    public void setVaccination(LocalDate dateTime) {
        numberOfVaccination++;
        lastVaccination = dateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return socialSecurityNumber.equals(citizen.socialSecurityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber);
    }

    @Override
    public String toString() {
        return name + ";" + zipCode + ";" + age + ";" + email + ";" + socialSecurityNumber;
    }
}
