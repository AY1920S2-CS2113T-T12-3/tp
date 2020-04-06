package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class DeadlineCompletionStatusNotABooleanException extends CustomException {
    public DeadlineCompletionStatusNotABooleanException() {
        super("Completion status should be a boolean value from the following list"
                + " [{True,TRUE,true},{False,FALSE,false}]");
    }
}