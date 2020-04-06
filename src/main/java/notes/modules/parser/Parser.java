package notes.modules.parser;

import exception.NotesInvalidAddMessageException;
import notes.modules.ModuleManager;
import notes.modules.command.AddCommand;
import notes.modules.command.Command;
import notes.modules.command.ExitCommand;
import notes.modules.command.ListCommand;

//@@author terrytay
public class Parser {
    private String userCommandText;
    private String userInput;

    /**
     * Takes in the user input and parse it into understandable
     * commands and return the command needed.
     *
     * @param moduleManager ModuleManager object used to manage modules.
     * @param userInput input from the user
     * @return method to call Command of specific type
     * @throws Exception for invalid commands
     */
    public Command parseCommand(String userInput, ModuleManager moduleManager) throws Exception {
        try {
            this.userInput = userInput;
            userCommandText = userInput.split(" ")[0];

            switch (userCommandText) {
            case "redo":
            case "undo":
                return new AddCommand(
                        moduleManager, userCommandText);
            case "add":
                String message = userInput.split(userCommandText + " ")[1];
                return new AddCommand(
                        moduleManager, message, userCommandText);
            case "list":
                return new ListCommand(moduleManager.getMessages());
            case "exit":
                return new ExitCommand();
            default:
                throw new Exception();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NotesInvalidAddMessageException();
        } catch (Exception e) {
            throw new Exception("Please specify a right command.");
        }
    }
}
