package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;
    private static final int MIN_BIRTHYEAR = 1900;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) throws IllegalArgumentException {
        SsnValidator ssnValidator = new SsnValidator();

        if (name.length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name argument is empty");
        }

        if(ssnValidator.isValidSsn(socialSecurityNumber)) {
            this.socialSecurityNumber = socialSecurityNumber;
        }else{
            throw new IllegalArgumentException("Social Security Number is not valid.");
        }

        if (yearOfBirth > MIN_BIRTHYEAR) {
            this.yearOfBirth = yearOfBirth;
        } else {
            throw new IllegalArgumentException("Year of birth must be larger than 1900!");
        }
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
