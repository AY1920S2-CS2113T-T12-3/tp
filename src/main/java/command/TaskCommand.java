package command;

import parser.Parser;
import task.TaskList;
import ui.Ui;
import static ui.Constants.BYE_COMMAND;
import static ui.Constants.BYE_MESSAGE;

/**
 * Used to run all the functions related to tasks.
 */
public class TaskCommand {

    /**
     * Runs all the command for tasks.
     *
     * @param taskList Refers to the current list of tasks.
     * @param ui UI object used to interact with user.
     * @param parser Object used to parse the user input into commands.
     */
    public static void runCommands(TaskList taskList, Ui ui, Parser parser) {
        ui.printHelp();
        String fullCommand;
        Command command;

        fullCommand = ui.getUserIn();
        while (!fullCommand.equals(BYE_COMMAND)) {
            try {
                command = parser.parseCommand(fullCommand);
                command.executeCommand(taskList, ui);
            } catch (Exception exception) {
                ui.printLine();
                ui.printMessage(exception.getMessage());
                ui.printLine();
            }
            fullCommand = ui.getUserIn();

        }
        ui.printLine();
        ui.printMessage(BYE_MESSAGE);
        ui.printLine();
    }

}
