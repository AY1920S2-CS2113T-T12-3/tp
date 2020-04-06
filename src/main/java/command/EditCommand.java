package command;

import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Command is used to delete a task at a specific index.
 */
public class EditCommand extends CommandWithIndex {

    /**
     * Constructor for commands with EditCommand object.
     * Creates a new EditCommand object if the correct command is used.
     *
     * @param commandSplit     Contains information with regards to the index to be operated at.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the index specified is invalid/ The wrong format is used for the command.
     */
    public EditCommand(String[] commandSplit, boolean isOneWordCommand) throws Exception {
        super(commandSplit, isOneWordCommand);
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskList.editTask(getIndex(), ui);
    }
}
