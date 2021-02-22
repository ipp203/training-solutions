package exam03retake01;

public class CdvCheck {

    public static final int NUMBER_LENGTH = 10;
    public static final int CHECK_NUMBER = 11;

    public boolean check(String cvdNumber) {
        validateNumber(cvdNumber);

        char[] numberCharArray = cvdNumber.toCharArray();
        int[] numbers = new int[NUMBER_LENGTH];

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numbers[i] = Character.getNumericValue(numberCharArray[i]);
        }

        int result = 0;
        for (int i = 0; i < NUMBER_LENGTH - 1; i++) {
            result += (i + 1) * numbers[i];
        }
        return result % CHECK_NUMBER == numbers[NUMBER_LENGTH - 1];
    }

    private void validateNumber(String cvdNumber) {
        if (cvdNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("Arguments length must be 10!");
        }
        char[] numberCharArray = cvdNumber.toCharArray();
        for (char c : numberCharArray) {
            if (Character.isAlphabetic(c)) {
                throw new IllegalArgumentException("Argument must be number");
            }
        }
    }
}
