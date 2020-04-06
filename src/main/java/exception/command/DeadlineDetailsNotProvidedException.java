package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class DeadlineDetailsNotProvidedException extends CustomException {
    public DeadlineDetailsNotProvidedException() {
        super("Deadline details are not provided");
    }
}
