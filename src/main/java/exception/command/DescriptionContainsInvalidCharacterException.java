package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class DescriptionContainsInvalidCharacterException extends CustomException {

    public static final String DESCRIPTION_SHOULDN_T_CONTAIN_INVALID_CHARACTERS = "Description shouldn't contain '/' "
            + "and '#' characters";

    public DescriptionContainsInvalidCharacterException() {
        super(DESCRIPTION_SHOULDN_T_CONTAIN_INVALID_CHARACTERS);
    }
}