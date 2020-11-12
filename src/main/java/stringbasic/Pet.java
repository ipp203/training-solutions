package stringbasic;


import java.time.LocalDate;

public class Pet {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    String registrationNumb;

    public Pet(String name, LocalDate birthDate, Gender gender, String registrationNumb) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.registrationNumb = registrationNumb;
    }

    public String getName() {
        return name;
    }

    public LocalDate getYearOfBirth() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegistrationNumb() {
        return registrationNumb;
    }
}
