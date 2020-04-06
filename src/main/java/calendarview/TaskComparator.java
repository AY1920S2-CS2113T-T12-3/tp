package calendarview;

import task.Task;
import java.util.Comparator;

/**
 * This comparator class allows for the priority queue to sort the tasks by its priority.
 */
public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task, Task t1) {
        if (task.getPriority() < t1.getPriority()) {
            return -1;
        } else if (task.getPriority() == t1.getPriority()) {
            return 0;
        }
        return 1;
    }
}