package task;

import java.time.LocalDate;

//@@author GanapathySanathBalaji

public abstract class Task {

    public TaskType taskType;

    public abstract int getPriority();

    public abstract LocalDate getDate();

    public abstract boolean hasKeyword(String keyword) throws Exception;

    public abstract String getFormattedDetails();

    public abstract String getTaskInformation();

    public abstract long numberOfDaysLeft();

    public abstract String getCalendarTaskDetails();
}
