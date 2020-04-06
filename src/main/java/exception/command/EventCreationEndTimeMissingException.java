package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class EventCreationEndTimeMissingException extends CustomException {
    public EventCreationEndTimeMissingException() {
        super("End time entered is empty, Please provide a valid end time");
    }
}
