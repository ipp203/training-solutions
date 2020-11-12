package controliteration.pi;

/*
Nem a régi s durva közelítés,
mi szótól szóig így kijön
betűiket számlálva.
Ludolph eredménye már,
ha itt végezzük húsz jegyen.
De rendre kijő még tíz pontosan,
Azt is bízvást ígérhetem.
 */

public class PiGenerator {
    private static final String POEM = "Nem a régi s durva közelítés,\n" +
            "mi szótól szóig így kijön\n" +
            "betűiket számlálva.\n" +
            "Ludolph eredménye már,\n" +
            "ha itt végezzük húsz jegyen.\n" +
            "De rendre kijő még tíz pontosan,\n" +
            "Azt is bízvást ígérhetem.";

    public static String getPoem() {
        return POEM;
    }

    public String piFromPoem(String text) {
        int charCounter;
        int textCounter = 0;
        String numberString = "";

        while (textCounter < text.length()) {
            charCounter = 0;
            while (Character.isAlphabetic(text.charAt(textCounter + charCounter))) {
                charCounter++;
            }
            if (charCounter > 0) {
                numberString = numberString + charCounter;
            }
            if (numberString.length() == 1) {
                numberString = numberString + '.';
            }
            textCounter += charCounter + 1;
        }
        return numberString;
    }
}
