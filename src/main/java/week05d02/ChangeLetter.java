package week05d02;

public class ChangeLetter {
    private static final String VOWELS = "aeiouAEIOU";
    private static final char STAR = '*';

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String changeVowels(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Parameter is null or empty.");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (VOWELS.indexOf(str.charAt(i)) >= 0) {
                result.append(STAR);
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
