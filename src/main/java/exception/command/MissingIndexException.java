package exception.command;


/**
 * This is the exception pertaining any illegal command with index usage.
 */
public class MissingIndexException extends Exception {

    public MissingIndexException(String errorMessage) {
        super(errorMessage);
    }
}
