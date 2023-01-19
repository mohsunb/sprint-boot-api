package bhos.student.exception;

public class SurnameAlreadyTakenException extends RuntimeException {

    private String message;

    public SurnameAlreadyTakenException() {

    }

    public SurnameAlreadyTakenException(String message) {
        super(message);
        this.message = message;
    }
}
