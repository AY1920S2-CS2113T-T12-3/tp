package exception.command;

import exception.CustomException;

public class MisuseOfSetDoneWithEvent extends CustomException {
    public MisuseOfSetDoneWithEvent() {
        super("Task of event type cannot be marked as done");
    }
}
