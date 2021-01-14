package week11.d04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameLength {

    public List<Integer> getLengths(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("List of names is null");
        }
        Set<Integer> result = new HashSet<>();
        for (String name : names) {
            if (name!=null && !name.isBlank() && name.toUpperCase().charAt(0) == 'J') {
                result.add(name.length());
            }
        }
        return new ArrayList<>(result);
    }
}
