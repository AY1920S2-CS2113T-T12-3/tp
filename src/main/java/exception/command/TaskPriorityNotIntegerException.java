package exception.command;

import exception.CustomException;

public class TaskPriorityNotIntegerException extends CustomException {
    public TaskPriorityNotIntegerException() {
        super("Priority should be an integer");
    }
}