package command;

import exception.command.IndexNotIntegerException;
import exception.command.MissingIndexException;
import task.TaskList;
import ui.Ui;

public class CommandWithIndex extends Command {


    /** Denotes the index at which the executeCommand method will operate at. */
    private static int index;

    /**
     * Constructor for commands with index, or CommandWithIndex object.
     * Creates a new CommandWithIndex object if the correct command is used.
     *
     * @param commandSplit Contains information with regards to the index to be operated at.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the index specified is invalid/ The wrong format is used for the command.
     */
    public CommandWithIndex(String[] commandSplit, boolean isOneWordCommand) throws Exception {
        if (isOneWordCommand) {
            String errorMessage = getErrorMessage(commandSplit[0]);
            throw new MissingIndexException(errorMessage);
        }
        try {
            setIndex(Integer.parseInt(commandSplit[1]));
        } catch (NumberFormatException e) {
            throw new IndexNotIntegerException();
        }
    }

    /**
     * This method gets the index where the process should be executed.
     * @return integer value, which denotes the index mentioned above.
     */

    public static int getIndex() {
        return index;
    }

    /**
     * This method sets the value of the index attribute in CommandWithIndex object.
     * @param index this is the value of the index that constructor will set.
     */
    public static void setIndex(int index) {
        CommandWithIndex.index = index;
    }

    /**
     * This method assigns the error message based on command used.
     * @param commandType this is the type of command entered by user.
     * @return String value of the error message depending on command type.
     */
    public String getErrorMessage(String commandType) {
        switch (commandType) {
        case "delete":
            return "Index to delete not mentioned";
        case "edit" :
            return "Index to edit not mentioned";
        case "done" :
            return "Index to be marked as done not mentioned";
        default:
            return null;
        }
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) throws Exception {

    }
}
