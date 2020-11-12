package introexception.patient;

public class SsnValidator {
    private static final int SSNLENGTH = 9;

    private int charToInt(char c) {
        return (int) c - '0';
    }

    public boolean isValidSsn(String ssn) {
        if (ssn.length() != SSNLENGTH) {
            return false;
        }

        try {
            Integer.parseInt(ssn);
        } catch (NumberFormatException nfe) {
            return false;
        }
        int checkSum = ((charToInt(ssn.charAt(0)) + charToInt(ssn.charAt(2)) + charToInt(ssn.charAt(4)) + charToInt(ssn.charAt(6))) * 3 +
                (charToInt(ssn.charAt(1)) + charToInt(ssn.charAt(3)) + charToInt(ssn.charAt(5)) + charToInt(ssn.charAt(7))) * 7) % 10;
        return checkSum == charToInt(ssn.charAt(8));
    }
}
