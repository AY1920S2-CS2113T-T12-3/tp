package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysToFinishNotPositiveException extends CustomException {
    public SchedulableTaskDaysToFinishNotPositiveException() {
        super("Number of days to finish should be greater than 1");
    }
}