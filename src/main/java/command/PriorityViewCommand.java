package command;

import exception.command.MisuseOfPriorityCommandException;
import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Displays the list of tasks added so far in decreasing order of their priority.
 */
public class PriorityViewCommand extends Command {

    /**
     * Constructor for the PriorityViewCommand Object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public PriorityViewCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfPriorityCommandException();
        }
    }


    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskList.priorityView(ui);
    }
}
