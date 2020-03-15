package exception.command;

import exception.CustomException;

public class EventStartTimeAfterEndTimeException extends CustomException {
    public EventStartTimeAfterEndTimeException() {
        super("Start time should be before End time");
    }
}