package db_covid;

public class BoolString {
    private boolean qual;
    private String message;

    public BoolString(boolean qual, String message) {
        this.qual = qual;
        this.message = message;
    }

    public boolean getQual() {
        return qual;
    }

    public String getMessage() {
        return message;
    }
}
