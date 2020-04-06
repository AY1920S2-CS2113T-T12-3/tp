package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskEmptyDescriptionException extends CustomException {
    public SchedulableTaskEmptyDescriptionException() {
        super("Description of task shouldn't be empty");
    }
}