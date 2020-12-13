package week03.d05;

public class Operation {
    private int left, right;

    public Operation(String str) {
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException("Invalid argument");
        }
        left = Integer.parseInt(str.substring(0, str.indexOf('+')));
        right = Integer.parseInt(str.substring(str.indexOf('+') + 1));
    }

    public int getResult() {
        return left + right;
    }
}
