package week14.d03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserFilters {
    public UserFilter createFilter(List<Predicate<User>> predicates) {
        Predicate<User> predResult = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                boolean result = true;
                for (Predicate<User> predicate : predicates) {
                    result = result && predicate.test(user);
                }
                return result;
            }
        };

        return users -> {
            List<User> result = new ArrayList<>();
            for (User user : users) {
                if (predResult.test(user)) {
                    result.add(user);
                }
            }
            return result;
        };
    }
}
