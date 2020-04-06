package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysLeftNotPositiveException extends CustomException {
    public SchedulableTaskDaysLeftNotPositiveException() {
        super("Number of days left should be greater than 1");
    }
}