package week15.d04;

public enum CharType {
    VOWEL("aáeéiíoóuúüű"),
    CONSONANT("bcdfghjklmnpqrstvwxyz"),
    OTHER("");

    private String letters;

    CharType(String letters) {
        this.letters = letters;
    }

    public static CharType charIntToCharType(int c) {
        String s = Character.toString((char) c);
        if (VOWEL.letters.contains(s)) {
            return CharType.VOWEL;
        }
        if (CONSONANT.letters.contains(s)) {
            return CharType.CONSONANT;
        }
        return CharType.OTHER;
    }
}
