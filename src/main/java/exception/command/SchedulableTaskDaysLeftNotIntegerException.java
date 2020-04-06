package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysLeftNotIntegerException extends CustomException {
    public SchedulableTaskDaysLeftNotIntegerException() {
        super("Number of days left should be an integer");
    }
}