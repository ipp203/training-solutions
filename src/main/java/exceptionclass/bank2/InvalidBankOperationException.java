package exceptionclass.bank2;

public class InvalidBankOperationException extends RuntimeException {

    public InvalidBankOperationException(String message) {
        super(message);
    }


}
