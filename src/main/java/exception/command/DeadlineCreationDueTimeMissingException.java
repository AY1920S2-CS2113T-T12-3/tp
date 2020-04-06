package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class DeadlineCreationDueTimeMissingException extends CustomException {
    public DeadlineCreationDueTimeMissingException() {
        super("Due time entered is empty, Please provide a valid due time");
    }
}
