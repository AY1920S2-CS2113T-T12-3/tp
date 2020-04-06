package command;

import task.TaskList;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * Object represents a command and contains all the required information and implementation to execute it.
 */
public abstract class Command {

    /**
     * Executes the command based on the information provided by the user.
     *
     * @param taskList Contains the list of tasks on which the commands are executed on.
     * @param ui This handles the interaction with Users.
     * @throws Exception If issues are found during execution of command.
     */
    public abstract void executeCommand(TaskList taskList, Ui ui) throws Exception;

}
