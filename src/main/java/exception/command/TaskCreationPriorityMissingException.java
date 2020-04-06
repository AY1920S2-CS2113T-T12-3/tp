package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class TaskCreationPriorityMissingException extends CustomException {
    public TaskCreationPriorityMissingException() {
        super("Priority entered is empty, Please provide a valid priority value");
    }
}
