package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {
    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        Scanner scn = new Scanner(intString);
        if (delimiter != null) {
            scn.useDelimiter(delimiter);
        }

        int result = 0;
        try {
            while (scn.hasNext()) {
                result += scn.nextInt();
            }
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        return result;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, " ");
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        StringBuilder result = new StringBuilder();
        String s;
        Scanner scn = new Scanner(text);
        int numberOfLines=0;

        while (scn.hasNextLine()) {
            s = scn.nextLine();
            if (s.contains(word)) {
                if (numberOfLines>0) {
                    result.append("\n");
                }
                result.append(s);
                numberOfLines++;
            }
        }
        return result.toString();
    }
}
