package command;

import exception.command.MisuseOfCountdownCommandException;
import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Displays the list of tasks added so far in increasing order of their dates.
 */
public class CountdownCommand extends Command {

    /**
     * Constructor for the CountdownCommand Object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public CountdownCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfCountdownCommandException();
        }
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskList.countdownView(ui);
    }
}
