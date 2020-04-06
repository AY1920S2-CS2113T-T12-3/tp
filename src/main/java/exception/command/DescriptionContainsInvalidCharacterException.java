package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class DescriptionContainsInvalidCharacterException extends CustomException {
    public DescriptionContainsInvalidCharacterException() {
        super("Description shouldn't contain '/' and '#' characters");
    }
}