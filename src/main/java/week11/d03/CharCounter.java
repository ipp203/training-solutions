package week11.d03;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    private Map<Character, Integer> charMap;

    public int countChars(String[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Chars is null");
        }
        int result = 0;
        charMap = new HashMap<>();
        for (String s : chars) {
            putStringIntoMap(s);
        }
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue().equals(chars.length)) {
                result++;
            }
        }
        return result;
    }

    private void putStringIntoMap(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String is null");
        }
        for (int i = 0; i < str.length(); i++) {
            Character actChar = str.charAt(i);
            if (charMap.containsKey(actChar)) {
                charMap.put(actChar, charMap.get(actChar) + 1);
            } else {
                charMap.put(actChar, 1);
            }
        }
    }

}
