package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysToFinishNotIntegerException extends CustomException {
    public SchedulableTaskDaysToFinishNotIntegerException() {
        super("Number of days to finish task should be an integer");
    }
}