package command;

import task.TaskList;
import ui.Ui;

//@@ author NizarMohd
/**
 * This class executes the done command.
 */
public class DoneCommand extends CommandWithIndex {

    /**
     * Constructor for DoneCommand object.
     * Creates a new DoneCommand object if the correct command is used.
     *
     * @param commandSplit     Contains information with regards to the index to be operated at.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the index specified is invalid/ The wrong format is used for the command.
     */
    public DoneCommand(String[] commandSplit, boolean isOneWordCommand) throws Exception {
        super(commandSplit, isOneWordCommand);
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) throws Exception {
        taskList.marksAsDone(getIndex(), ui);
    }
}
