package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void validate() {
        List<User> users = new ArrayList<>();
        users.add(new User(null, 0));
        users.add(new User("", 0));
        users.add(new User("AAA", -10));
        users.add(new User("AAA", 150));
        users.add(new User("AAA", 50));

    }
}