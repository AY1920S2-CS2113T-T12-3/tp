package command;

import exception.MisuseOfCalenderCommandException;
import task.Task;
import task.TaskList;
import ui.Ui;
import calenderview.CalenderView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//@@author NizarMohd
/**
 * This class deals with the command used for Calender View.
 */
public class CalenderCommand extends Command {

    /**
     * This constructs the command.
     * @param isOneWordCommand checks to see if the user entered the command correctly.
     * @throws Exception is thrown if the user entered the command wrongly.
     */
    public CalenderCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfCalenderCommandException();
        }
    }

    /**
     * This method retrieves the mapping between the days to the current tasks for that month.
     * @param tasks this is the list of tasks in taskList.
     * @param c this is the calenderView class that was instantiated to convert the tasks into calender view.
     * @return a hashMap that maps the days to its designated tasks.
     */
    public static HashMap<Integer, LinkedList<Task>> checkExistingTasks(ArrayList<Task> tasks, CalenderView c) {
        HashMap<Integer, LinkedList<Task>> dayToTaskHashMap = new HashMap<>();
        for (Task task : tasks) {
            LocalDate date = task.getDate();
            if (date.getMonthValue() == c.month && date.getYear() == c.year) {
                int day = date.getDayOfMonth();
                dayToTaskHashMap.computeIfAbsent(day, k -> new LinkedList<Task>());
                dayToTaskHashMap.get(day).add(task);
            }
        }
        return dayToTaskHashMap;
    }


    @Override
    public void executeCommand(TaskList taskList, Ui ui) {
        CalenderView c = new CalenderView(ui);
        HashMap<Integer, LinkedList<Task>> map = checkExistingTasks(taskList.tasks, c);
        c.setMap(map);
        c.printCalender();
        ui.printLine();
    }
}
