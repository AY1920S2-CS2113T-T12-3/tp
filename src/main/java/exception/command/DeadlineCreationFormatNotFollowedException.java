package exception.command;

import exception.CustomException;

import static ui.Constants.HELP_DESCRIPTION_5;

//@@author GanapathySanathBalaji
public class DeadlineCreationFormatNotFollowedException extends CustomException {
    public DeadlineCreationFormatNotFollowedException() {
        super("Please follow the correct format to add a new deadline" + System.lineSeparator() + HELP_DESCRIPTION_5);
    }
}