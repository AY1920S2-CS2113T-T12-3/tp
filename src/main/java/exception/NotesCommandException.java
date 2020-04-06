package exception;

public class NotesCommandException extends CustomException {
    public NotesCommandException() {
        super("Please enter a valid command. e.g. To add a module, enter \"add [modulename]\"");
    }
}
