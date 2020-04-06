package command;

import exception.command.MisuseOfClearCommandException;
import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * This command is used to clear all the tasks in the list.
 */
public class ClearCommand extends Command {

    /**
     * Constructor for the ClearCommand Object.
     * Checks if the user given input follows the correct format.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public ClearCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfClearCommandException();
        }
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskList.clearTasks(ui);
    }
}
