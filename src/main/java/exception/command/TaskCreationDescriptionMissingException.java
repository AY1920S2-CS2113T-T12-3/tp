package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class TaskCreationDescriptionMissingException extends CustomException {
    public TaskCreationDescriptionMissingException() {
        super("Description is empty, Please provide a valid description");
    }
}
