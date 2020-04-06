package exception;

public class NotesInvalidAddMessageException extends CustomException {
    public NotesInvalidAddMessageException() {
        super("Please specify a message to add i.e. add [message here]");
    }
}
