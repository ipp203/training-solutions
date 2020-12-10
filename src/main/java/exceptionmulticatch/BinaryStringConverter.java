package exceptionmulticatch;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryString) {
        if (binaryString == null) {
            throw new NullPointerException("binaryString null");
        }
        if (!binaryStringValidator(binaryString)) {
            throw new IllegalArgumentException("binaryString not valid");
        }
        boolean[] booleans = new boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            booleans[i] = binaryString.charAt(i) == '1';
        }
        return booleans;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans.length == 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < booleans.length; i++) {
            result.append(booleans[i] ? '1' : '0');
        }
        return result.toString();
    }

    private boolean binaryStringValidator(String binaryString) {
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

}
