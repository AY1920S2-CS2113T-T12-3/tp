package exception.command;

import exception.CustomException;


public class InvalidEndTimeException extends CustomException {
    public InvalidEndTimeException() {
        super("End time provided is invalid or in wrong format (Should be HH:MM) 24 Hr format");
    }
}