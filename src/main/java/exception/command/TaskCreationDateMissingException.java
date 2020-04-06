package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class TaskCreationDateMissingException extends CustomException {
    public TaskCreationDateMissingException() {
        super("Date entered is empty, Please provide a valid date");
    }
}
