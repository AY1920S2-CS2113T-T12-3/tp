package command;

import exception.command.InvalidHelpCommandException;
import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Command is used to print the list of commands supported.
 */
public class HelpCommand extends Command {

    /**
     * Constructor for the HelpCommand object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public HelpCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new InvalidHelpCommandException();
        }
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        ui.printHelp(true);
    }
}
