package week05.d03;

import java.util.List;

public class UserValidator {
    public void validate(List<User> users) {
        if (users == null) {
            throw new RuntimeException("Parameter is null");
        }
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getName() == null || user.getName().isBlank()) {
                throw new RuntimeException("A " + i + ". felhasználó neve üres.");
            }
            if (user.getAge() < 0) {
                throw new RuntimeException("A " + user.getName() + ". felhasználó kora negatív.");
            }
            if (user.getAge() > 120) {
                throw new RuntimeException("A " + user.getName() + ". felhasználó kora nagyobb, mint 120.");
            }
        }

    }
}
