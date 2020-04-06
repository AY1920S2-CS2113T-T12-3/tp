package command;

import exception.command.MisuseOfViewCommandException;
import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Displays the list of tasks added so far.
 */
public class ViewCommand extends Command {

    /**
     * Constructor for the ViewCommand Object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public ViewCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfViewCommandException();
        }
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskList.listTasks(ui);
    }
}
