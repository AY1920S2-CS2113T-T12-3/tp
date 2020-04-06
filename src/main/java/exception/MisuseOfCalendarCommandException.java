package exception;

//@@author NizarMohd
/**
 * This exception handles with when the user enters the calendar command wrongly.
 */
public class MisuseOfCalendarCommandException extends CustomException {
    public MisuseOfCalendarCommandException() {
        super("Wrong command used for calendar command. (Should be :calendar )");
    }
}
