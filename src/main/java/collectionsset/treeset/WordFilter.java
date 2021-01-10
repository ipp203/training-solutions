package collectionsset.treeset;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> ts = new TreeSet<>();
        for (String s : randomStrings) {
            ts.add(s);
        }
        return ts;
    }

}
