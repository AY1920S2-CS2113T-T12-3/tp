package command;

import exception.command.MisuseOfScheduleCommandException;
import exception.command.NumberOfTasksToBeScheduledNotAnIntegerException;
import exception.command.NumberOfTasksToBeScheduledNotPositiveException;
import task.TaskList;
import task.TaskScheduler;
import ui.Ui;

//@@author GanapathySanathBalaji
/**
 * This command is used to create schedule based on user input if its feasible.
 */
public class CreateScheduleCommand extends Command {

    TaskScheduler taskScheduler;

    /**
     * Constructor for the CreateScheduleCommand Object.
     * Checks if the user given input follows the correct format and creates a new object.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @param commandSplit Contains the information regarding the number of tasks to be scheduled.
     * @throws Exception If the wrong format is used.
     */
    public CreateScheduleCommand(boolean isOneWordCommand, String[] commandSplit) throws Exception {
        if (isOneWordCommand) {
            throw new MisuseOfScheduleCommandException();
        }
        try {
            int numberOfTasksToSchedule = Integer.parseInt(commandSplit[1]);
            if (numberOfTasksToSchedule <= 0) {
                throw new NumberOfTasksToBeScheduledNotPositiveException();
            }
            taskScheduler = new TaskScheduler(numberOfTasksToSchedule);
        } catch (NumberFormatException e) {
            throw new NumberOfTasksToBeScheduledNotAnIntegerException();
        }
    }


    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        taskScheduler.getTasks(ui);
        if (taskScheduler.scheduleTasks(ui)) {
            ui.printMessage("Tasks successfully scheduled.");
            taskScheduler.addScheduleToList(taskList, ui);
        } else {
            ui.printMessage("Tasks couldn't be scheduled.");
        }
        ui.printLine();
    }
}
