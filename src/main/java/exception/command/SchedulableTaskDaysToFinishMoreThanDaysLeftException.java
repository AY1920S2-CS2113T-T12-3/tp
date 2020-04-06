package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysToFinishMoreThanDaysLeftException extends CustomException {
    public SchedulableTaskDaysToFinishMoreThanDaysLeftException() {
        super("Number of days left should not be lesser than number of days to finish the task");
    }
}