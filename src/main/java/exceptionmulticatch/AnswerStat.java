package exceptionmulticatch;

public class AnswerStat {
    BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String binaryString) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(binaryString);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] booleans = convert(answers);
        int trues = 0;
        for (int i = 0; i < booleans.length; i++) {
            trues += booleans[i] ? 1 : 0;
        }
        return 100 * trues / booleans.length;
    }

}
