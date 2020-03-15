package studyarea;

/**
 * This is an extension of the Exception class that exist only for StudyArea related modules.
 */

public class IllegalStudyAreaException extends Exception {

    public IllegalStudyAreaException(String message) {
        super(message);
    }
}