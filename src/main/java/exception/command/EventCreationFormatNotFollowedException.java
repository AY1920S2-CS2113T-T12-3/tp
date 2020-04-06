package exception.command;

import exception.CustomException;

import static ui.Constants.HELP_DESCRIPTION_3;

//@@author GanapathySanathBalaji
public class EventCreationFormatNotFollowedException extends CustomException {
    public EventCreationFormatNotFollowedException() {
        super("Please follow the correct format to add a new event" + System.lineSeparator() + HELP_DESCRIPTION_3);
    }
}