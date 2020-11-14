package stringbuilder;

public class PalindromeValidator {
    public boolean isPalindrome(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        String myWord = word.trim().toLowerCase();
        StringBuilder sb = new StringBuilder(myWord);

        sb.reverse();

        return myWord.equals(sb.toString());
    }
}
