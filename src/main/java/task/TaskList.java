package task;

import exception.command.IllegalDoneCommandException;
import exception.command.MisuseOfSetDoneWithEvent;
import ui.Constants;
import ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ui.Constants.DEADLINE_MARKED_AS_DONE;
import static ui.Constants.RE_ENTER_VALID_INDEX_TO_MARK_AS_DONE_MESSAGE;

//@@author GanapathySanathBalaji
/**
 * Handles all functions related to the list of events.
 */
public class TaskList {


    /**
     * Stores the task's information.
     */
    public ArrayList<Task> tasks;

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Constructor for the TaskList class.
     */
    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Overloaded constructor for TaskList class.
     *
     * @param tasks The list of events the task's list of events is initialised with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the number of tasks currently stored.
     *
     * @return The number of tasks stored currently.
     */
    public int getTaskListSize() {
        return tasks.size();
    }

    /**
     * Adds a new task to the list.
     *
     * @param ui      This allows Task List class to interact with User.
     * @param newTask represents the new task to be added.
     */
    public void addTask(Task newTask, Ui ui) {
        tasks.add(newTask);
        ui.printLine();
        ui.printMessage(Constants.NEW_TASK_ADDED_MESSAGE);
        ui.printMessage(newTask.getTaskInformation());
        ui.printLine();
    }

    /**
     * Displays the current list of tasks.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void listTasks(Ui ui) {
        ui.printLine();
        if (tasks.size() > 0) {
            ui.printMessage(Constants.TASK_LIST_AS_FOLLOWS);
            int eventNumber = 1;
            for (Task task : tasks) {
                ui.printMessage(eventNumber + Constants.CLOSING_BRACKET + task.getTaskInformation());
                eventNumber++;
            }
        } else {
            ui.printMessage(Constants.LIST_EMPTY_MESSAGE);
        }
        ui.printLine();
    }

    /**
     * Deletes the task at the specified index.
     *
     * @param ui    This allows TaskList class to interact with User.
     * @param index The index (1-based) of the task to be deleted.
     */
    public void deleteTask(int index, Ui ui) {
        try {
            if (index > tasks.size() | index <= 0) {
                throw new IndexOutOfBoundsException();
            }
            ui.printLine();
            ui.printMessage(Constants.TASK_AT_INDEX_DELETED_MESSAGE);
            ui.printMessage(tasks.get(index - 1).getTaskInformation());
            tasks.remove(index - 1);
            ui.printMessage(Constants.NOW_YOU_HAVE + tasks.size() + Constants.TASK_S_IN_YOUR_LIST);
            ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.log(Level.INFO, Constants.INDEX_TO_BE_DELETED_OUT_OF_BOUNDS_LOG);
            ui.printLine();
            ui.printMessage(Constants.RE_ENTER_VALID_INDEX_TO_DELETE_MESSAGE);
            ui.printLine();
        }
    }

    /**
     * Calls a helper function to edit the task at the specified index.
     *
     * @param ui    This allows TaskList class to interact with User.
     * @param index The index (1-based) of the task to be deleted.
     */
    public void editTask(int index, Ui ui) {
        try {
            if (index > tasks.size() | index <= 0) {
                throw new IndexOutOfBoundsException();
            }
            /* Converting to '0' based index */
            editTaskAtIndex(index - 1, ui);
            ui.printLine();
            ui.printMessage(Constants.TASK_AT_INDEX_EDITED_MESSAGE);
            ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            ui.printLine();
            ui.printMessage(Constants.RE_ENTER_VALID_INDEX_TO_EDIT_MESSAGE);
            ui.printLine();
        }
    }


    /**
     * Edits the task at the specified index.
     *
     * @param index The index of the task to be edited.
     * @param ui This allows TaskList class to interact with User.
     * @throws IndexOutOfBoundsException If the index provided is invalid (i.e, out of bounds).
     */
    private void editTaskAtIndex(int index, Ui ui) throws IndexOutOfBoundsException {
        switch (tasks.get(index).taskType) {
        case Event:
            Event oldEvent = (Event) tasks.get(index);
            Event updatedEvent = oldEvent.editEvent(ui);
            tasks.set(index, updatedEvent);
            break;
        case Deadline:
            Deadline oldDeadline = (Deadline) tasks.get(index);
            Deadline updatedDeadline = oldDeadline.editDeadline(ui);
            tasks.set(index, updatedDeadline);
            break;
        default:
            LOGGER.log(Level.SEVERE, Constants.INVALID_TASK_TYPE_LOG);
            ui.printMessage(Constants.ERROR_ENCOUNTERED_DURING_EXECUTION_MESSAGE);
            break;
        }
    }


    /**
     * Clears all the tasks currently stored.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void clearTasks(Ui ui) {
        tasks.clear();
        ui.printLine();
        ui.printMessage(Constants.TASK_LIST_CLEARED_MESSAGE);
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by their priority by calling a helper function.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void priorityView(Ui ui) {
        ArrayList<Task> tasksSortedByPriority = tasks;
        tasksSortedByPriority.sort(Comparator.comparingInt(Task::getPriority));
        Collections.reverse(tasksSortedByPriority);
        ui.printLine();
        if (tasks.size() > 0) {
            printTasksSortedByPriority(ui, tasksSortedByPriority);
        } else {
            ui.printMessage(Constants.LIST_EMPTY_MESSAGE);
        }
        ui.printLine();
    }

    /**
     * Prints the tasks sorted by their priority.
     *
     * @param ui This allows TaskList class to interact with User.
     * @param tasksSortedByPriority The sorted list of tasks.
     */
    private void printTasksSortedByPriority(Ui ui, ArrayList<Task> tasksSortedByPriority) {
        int taskNumber = 1;
        ui.printMessage(Constants.LIST_SORTED_BY_PRIORITY_MESSAGE);
        for (Task task : tasksSortedByPriority) {
            ui.printMessage(taskNumber + Constants.CLOSING_BRACKET + task.getTaskInformation());
            taskNumber++;
        }
    }

    /**
     * Lists all the tasks sorted by date along with the days remaining by calling a helper function.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void countdownView(Ui ui) {
        ArrayList<Task> tasksSortedByDate = tasks;
        tasksSortedByDate.sort(Comparator.comparing(Task::getDate));
        ui.printLine();
        if (tasks.size() > 0) {
            printTasksSortedByDate(ui, tasksSortedByDate);
        } else {
            ui.printMessage(Constants.LIST_EMPTY_MESSAGE);
        }
        ui.printLine();
    }

    /**
     * Prints the tasks sorted by date along with the days remaining.
     *
     * @param ui This allows TaskList class to interact with User.
     * @param tasksSortedByDate The sorted list of tasks.
     */
    private void printTasksSortedByDate(Ui ui, ArrayList<Task> tasksSortedByDate) {
        int taskNumber = 1;
        ui.printMessage(Constants.LIST_SORTED_ON_DAYS_LEFT_MESSAGE);
        for (Task task : tasksSortedByDate) {
            if (!task.getDate().isBefore(LocalDate.now())) {
                ui.printMessage(taskNumber + Constants.CLOSING_BRACKET + task.getTaskInformation()
                        + Constants.ARROW_SYMBOL + task.numberOfDaysLeft() + Constants.DAYS_LEFT);
                taskNumber++;
            }
        }
    }

    /**
     * Displays the list of tasks containing the keyword.
     *
     * @param ui      This allows TaskList class to interact with User.
     * @param keyword The keyword to be searched for.
     * @throws Exception If the keyword is empty.
     */
    public void searchTasks(String keyword, Ui ui) throws Exception {
        boolean hasMatchedTask = checkForMatchedTasks(keyword);
        ui.printLine();
        if (hasMatchedTask) {
            ui.printMessage(Constants.SEARCH_LIST_MESSAGE);
            printMatchedTasks(keyword, ui);
        } else {
            ui.printMessage(Constants.SEARCH_EMPTY_MESSAGE);
        }
        ui.printLine();
    }

    /**
     * Used to check if there is at least one task containing the keyword in it's description.
     *
     * @param keyword The word used for search.
     * @return true if at least one task has a description containing the keyword and false otherwise
     * @throws Exception If keyword used is empty.
     */
    private boolean checkForMatchedTasks(String keyword) throws Exception {
        boolean hasMatchedTask = false;
        for (Task task : tasks) {
            if (task.hasKeyword(keyword)) {
                hasMatchedTask = true;
                break;
            }
        }
        return hasMatchedTask;
    }

    /**
     * Displays the list of tasks containing the keyword in their descriptions.
     *
     * @param keyword The word used for search.
     * @param ui Used to interact with the user.
     * @throws Exception If the keyword is empty.
     */
    private void printMatchedTasks(String keyword, Ui ui) throws Exception {
        int taskNumber = 1;
        for (Task task : tasks) {
            if (task.hasKeyword(keyword)) {
                ui.printMessage(taskNumber + Constants.CLOSING_BRACKET + task.getTaskInformation());
                taskNumber++;
            }
        }
    }

    //@@author NizarMohd
    /**
     * This method checks if deadline has already been marked as done.
     * @param deadline this is the deadline that the user is trying to mark as done.
     * @param ui this object allows for interaction with the user.
     * @throws IllegalDoneCommandException is thrown when user tries to mark deadline as done when it has already been
     *          done.
     */

    public void checkIfDone(Deadline deadline, Ui ui) throws IllegalDoneCommandException {
        if (deadline.getIsDone()) {
            throw new IllegalDoneCommandException("Deadline has already been marked as done!");
        }
    }

    /**
     * This method checks for the upper and lower bounds of index.
     * @param index this is the index that is being checked.
     * @throws IllegalDoneCommandException is thrown when the user enters an index that is out of both bounds.
     */

    public void checkIndexBounds(int index) throws IllegalDoneCommandException {
        if (index < 0 || index >= tasks.size()) {
            throw new IllegalDoneCommandException(RE_ENTER_VALID_INDEX_TO_MARK_AS_DONE_MESSAGE);
        }
    }

    /**
     * This method executes the overall process to mark a deadline as done.
     * @param task this is the task to be set as done.
     * @param ui this object allows for interaction with User.
     * @throws IllegalDoneCommandException is thrown if user enters the done command wrongly.
     * @throws MisuseOfSetDoneWithEvent if User tries to set Event as done.
     */
    public void executeDone(Task task, Ui ui) throws IllegalDoneCommandException, MisuseOfSetDoneWithEvent {
        if (task.taskType.equals(TaskType.Deadline)) {
            Deadline deadline = (Deadline) task;
            checkIfDone(deadline, ui);
            deadline.setDone();
            ui.printLine();
            ui.printMessage(DEADLINE_MARKED_AS_DONE);
            ui.printMessage(deadline.getTaskInformation());
            ui.printLine();
        } else {
            throw new MisuseOfSetDoneWithEvent();
        }
    }
    /**
     * This method sets tasks of deadline type at the specified index as done.
     * @param index this is the index where the method will operate at.
     * @param ui this allows for interaction with the user.
     * @throws MisuseOfSetDoneWithEvent if user tries to set events as done.
     * @throws IllegalDoneCommandException if user uses the done command wrongly.
     */

    public void marksAsDone(int index, Ui ui) throws MisuseOfSetDoneWithEvent, IllegalDoneCommandException {
        index--;
        checkIndexBounds(index);
        Task task = tasks.get(index);
        executeDone(task, ui);
    }
}
