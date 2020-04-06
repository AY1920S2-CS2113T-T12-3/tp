package command;

import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Command is used to delete a task at a specific index.
 */
public class DeleteCommand extends CommandWithIndex {

    /**
     * Constructor for DeleteCommand object.
     * Creates a new DeleteCommand object if the correct command is used.
     *
     * @param commandSplit     Contains information with regards to the index to be operated at.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the index specified is invalid/ The wrong format is used for the command.
     */
    public DeleteCommand(String[] commandSplit, boolean isOneWordCommand) throws Exception {
        super(commandSplit, isOneWordCommand);
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskList.deleteTask(getIndex(), ui);
    }
}
