package exception;

//@@author terrytay
public abstract class CustomException extends Exception {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
