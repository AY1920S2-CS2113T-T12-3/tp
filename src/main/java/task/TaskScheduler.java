package task;

import ui.Constants;
import ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.PriorityQueue;

//@@author GanapathySanathBalaji
/**
 * Handles creation of schedules based on user's requirements.
 */
public class TaskScheduler {

    public static final String NINE_AM = "09:00";
    public static final String NINE_PM = "21:00";
    public static final String PRIORITY_FOR_SCHEDULED_TASKS = "0";
    private int numberOfTasksToSchedule;
    private PriorityQueue<SchedulableTask> taskQueue;
    private ArrayList<Task> toBeAddedToList;

    /**
     * Constructor for TaskScheduler.
     *
     * @param numberOfTasksToSchedule Denotes the number of tasks to be scheduled.
     */
    public TaskScheduler(int numberOfTasksToSchedule) {
        this.numberOfTasksToSchedule = numberOfTasksToSchedule;
        this.taskQueue = new PriorityQueue<>(numberOfTasksToSchedule, new TaskComparator());
        toBeAddedToList = new ArrayList<>();
    }

    /**
     * Used to get details of the tasks to be scheduled from the user.
     *
     * @param ui Used to interact with the user.
     */
    public void getTasks(Ui ui) {
        ui.printLine();
        ui.printMessage(Constants.ENTER_TASKS_IN_THE_FOLLOWING_FORMAT);
        ui.printMessage(Constants.SCHEDULABLE_TASK_FORMAT);
        for (int taskNumber = 1; taskNumber <= numberOfTasksToSchedule; taskNumber++) {
            SchedulableTask newSchedulableTask = new SchedulableTask();
            ui.printMessage(Constants.ENTER_DETAILS + taskNumber + Constants.COLON);
            try {
                String taskDetails = ui.getUserIn();
                String[] splitDetails = taskDetails.split(Constants.FORWARD_SLASH);
                newSchedulableTask.setDetails(splitDetails);
                addTaskToQueue(newSchedulableTask);
            } catch (Exception e) {
                ui.printMessage(e.getMessage());
                taskNumber--;
            }
        }
        ui.printMessage(Constants.DETAILS_CAPTURED_SUCCESSFULLY);
    }

    /**
     * Adds the task given to the queue.
     *
     * @param newSchedulableTask The task to be added to the queue.
     */
    private void addTaskToQueue(SchedulableTask newSchedulableTask) {
        taskQueue.add(newSchedulableTask);
    }


    /**
     * Creates a schedule based on the user's requirement if it's possible.
     *
     * @param ui Used to interact with the user.
     * @return isFeasible Denotes whether the user provided task is schedulable.
     */
    public boolean scheduleTasks(Ui ui) {
        int currentDay = 0;
        LocalDate startDate;
        String startOfDay = NINE_AM;
        String endOfDay = NINE_PM;
        StringBuilder scheduleCreated = new StringBuilder();
        boolean isFeasible = true;
        while (!taskQueue.isEmpty() && isFeasible) {
            SchedulableTask taskToBeScheduledNext = taskQueue.poll();
            scheduleCreated.append(taskToBeScheduledNext.taskDescription).append(Constants.FROM)
                    .append(LocalDate.now().plusDays(currentDay + 1));
            startDate = LocalDate.now().plusDays(currentDay);
            if (currentDay + taskToBeScheduledNext.numberOfDaysRequiredToFinishTask
                    > taskToBeScheduledNext.numberOfDaysLeft) {
                isFeasible = scheduleNotFeasible();
            } else {
                currentDay = addTaskToList(ui, currentDay, startDate, startOfDay, endOfDay,
                        PRIORITY_FOR_SCHEDULED_TASKS, scheduleCreated, taskToBeScheduledNext);
            }
        }
        if (isFeasible) {
            ui.printMessage(scheduleCreated.toString());
        }
        return isFeasible;
    }

    /**
     * Returns a false value to denote that the schedule is infeasible.
     *
     * @return false.
     */
    private boolean scheduleNotFeasible() {
        return false;
    }

    /**
     * Adds the task mentioned to the list of tasks.
     *
     * @param ui Used to interact with the user.
     * @param currentDay The actual date.
     * @param startDate The day at which the task starts.
     * @param startOfDay The time at which the activities for the day starts at.
     * @param endOfDay The time at which the activities for the day ends at.
     * @param defaultPriority Denotes the default value of priority used for scheduled tasks.
     * @param scheduleCreated Stores the schedule in form of a string.
     * @param taskToBeScheduledNext Denotes the current task that is added to the schedule.
     * @return The day the next task can be scheduled from if any.
     */
    private int addTaskToList(Ui ui, int currentDay, LocalDate startDate, String startOfDay, String endOfDay,
                              String defaultPriority, StringBuilder scheduleCreated,
                              SchedulableTask taskToBeScheduledNext) {
        LocalDate endDate;
        currentDay += taskToBeScheduledNext.numberOfDaysRequiredToFinishTask;
        scheduleCreated.append(Constants.TO).append(LocalDate.now().plusDays(currentDay))
                .append(System.lineSeparator()).append(Constants.TAB);
        endDate = LocalDate.now().plusDays(currentDay);
        for (LocalDate iterator = startDate.plusDays(1); !iterator.isAfter(endDate);
             iterator = iterator.plusDays(1)) {
            try {
                toBeAddedToList.add(new Event(taskToBeScheduledNext.taskDescription, iterator.toString(), startOfDay,
                        endOfDay, defaultPriority));
            } catch (Exception e) {
                ui.printMessage("Unexpected error");
            }
        }
        return currentDay;
    }

    /**
     * Add the scheduled tasks to the current list.
     *
     * @param taskList Contains the current list of tasks.
     * @param ui Used to interact with the user.
     */
    public void addScheduleToList(TaskList taskList, Ui ui) {
        taskList.tasks.addAll(toBeAddedToList);
    }
}

