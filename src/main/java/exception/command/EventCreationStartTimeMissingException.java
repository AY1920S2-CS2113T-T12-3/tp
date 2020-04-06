package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class EventCreationStartTimeMissingException extends CustomException {
    public EventCreationStartTimeMissingException() {
        super("Start time entered is empty, Please provide a valid start time");
    }
}
