package collectionsqueue.job;

public class NoJobException extends RuntimeException {
    private String message;

    public NoJobException(String message) {
        super(message);
    }

    public NoJobException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
