package exception;

//@@author NizarMohd
/**
 * This is the exception for when the user enters commands illegally when viewing the calendar.
 */
public class CalendarException extends Exception {

    public CalendarException(String message) {
        super(message);
    }
}
