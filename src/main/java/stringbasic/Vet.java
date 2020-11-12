package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    private boolean areEquals(Pet newPet) {
        for (Pet pet : pets) {
            if (pet.registrationNumb.equals(newPet.registrationNumb)) {
                return true;
            }
        }
        return false;
    }

    public void add(Pet newPet) {
        if (!areEquals(newPet)) {
            pets.add(newPet);
        }
    }
}
