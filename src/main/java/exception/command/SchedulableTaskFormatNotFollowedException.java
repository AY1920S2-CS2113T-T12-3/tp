package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskFormatNotFollowedException extends CustomException {
    public SchedulableTaskFormatNotFollowedException() {
        super("Please follow the format specified");
    }
}