package formatlocaleprintf;

import java.util.IllegalFormatException;

public class PrintFormat {

    public String checkException(String formatString, Integer i, Integer j) {
        String s;
        try {
            s = String.format(formatString, i, j);
        } catch (IllegalFormatException ife) {
            throw new IllegalArgumentException("Less objects then expected in format String!", ife);
        }
        return s;
    }

    public String printFormattedText(Double number) {
        return String.format("Total is: %,10.2f Ft", number);
    }

    public String printFormattedText(int count, String fruit) {
        return String.format("We counted %d %S in the basket", count, fruit);
    }

    public String printFormattedText(int number) {
        return String.format("Right edge of numbers set at 4 spaces from text:%4d", number);
    }

    public String printFormattedText(Integer i, Integer j, Integer k) {
        return String.format("Multiple objects containing text:%d\t%d\t%d", i, j, k);
    }
}
