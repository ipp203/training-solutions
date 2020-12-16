package week08.d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {
    public List<String> shortestWords(List<String> words) {
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (min > word.length()) {
                min = word.length();
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (min == word.length()) {
                result.add(word);
            }
        }
        return result;
    }
}
