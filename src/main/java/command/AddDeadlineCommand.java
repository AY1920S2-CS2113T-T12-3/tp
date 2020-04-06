package command;

import exception.command.DeadlineCreationDueTimeMissingException;
import exception.command.DeadlineCreationFormatNotFollowedException;
import exception.command.DeadlineDetailsNotProvidedException;
import exception.command.TaskCreationDateMissingException;
import exception.command.TaskCreationDescriptionMissingException;
import exception.command.TaskCreationPriorityMissingException;
import task.Deadline;
import task.TaskList;
import ui.Ui;

import java.time.LocalDate;

import static command.AddEventCommand.DATE_BEFORE_CURRENT_DATE_ERROR_MESSAGE;

//@@author GanapathySanathBalaji
/**
 * This command is used to add new deadlines to the TaskList.
 */
public class AddDeadlineCommand extends Command {

    public static final String SLASH_SYMBOL = "/";

    /** The new event to be added. */
    Deadline newDeadline;

    /**
     * Constructor for the AddCommand Object.
     * Abstracts out the details from the user input and uses it to create a new deadline object.
     *
     * @param deadlineDetails The array contains the information regarding the new deadline to be added.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used to create an event.
     */
    public AddDeadlineCommand(String[] deadlineDetails, boolean isOneWordCommand) throws Exception {
        if (isOneWordCommand) {
            throw new DeadlineDetailsNotProvidedException();
        }
        String[] details = deadlineDetails[1].split(SLASH_SYMBOL);
        isCorrectFormat(details);
        String description = details[0];
        String date = details[1].substring(2);
        String dueTime = details[2].substring(2);
        String priority = details[3].substring(2);
        newDeadline =  new Deadline(description, date, dueTime, priority, false);
        assert !newDeadline.getDate().isBefore(LocalDate.now()) : DATE_BEFORE_CURRENT_DATE_ERROR_MESSAGE;
    }

    /**
     * Checks if the correct format is used to create a deadline, if not an exception is thrown.
     *
     * @param details Details entered by user.
     * @throws Exception If any of the fields are missing.
     */
    private void isCorrectFormat(String[] details) throws Exception {
        if (details.length != 4) {
            throw new DeadlineCreationFormatNotFollowedException();
        }
        try {
            String description = details[0];
            checkDescription(description);
            String date = details[1];
            checkDate(date);
            String dueTime = details[2];
            checkDueTime(dueTime);
            String priority = details[3];
            checkPriority(priority);
            if (details[0].isBlank()) {
                throw new TaskCreationDescriptionMissingException();
            }
            if (details[1].substring(2).isBlank()) {
                throw new TaskCreationDateMissingException();
            }
            if (details[2].substring(2).isBlank()) {
                throw new DeadlineCreationDueTimeMissingException();
            }
            if (details[3].substring(2).isBlank()) {
                throw new TaskCreationPriorityMissingException();
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DeadlineCreationFormatNotFollowedException();
        }
    }

    /**
     * Checks if the description is provided in the correct format, throws an exception if wrong format is used.
     *
     * @param description String entered by user for description.
     * @throws Exception If wrong format is used.
     */
    private void checkDescription(String description) throws Exception {
        if (description.isBlank()) {
            throw new TaskCreationDescriptionMissingException();
        }
    }

    /**
     * Checks if the date is provided in the correct format, throws an exception if wrong format is used.
     *
     * @param date String entered by user for date.
     * @throws Exception If wrong format is used.
     */
    private void checkDate(String date) throws Exception {
        if (date.charAt(0) != 'd' || date.charAt(1) != ' ') {
            throw new DeadlineCreationFormatNotFollowedException();
        }
        if (date.substring(2).isBlank()) {
            throw new TaskCreationDateMissingException();
        }
    }

    /**
     * Checks if the priority is provided in the correct format, throws an exception if wrong format is used.
     *
     * @param priority String entered by user for priority.
     * @throws Exception If wrong format is used.
     */
    private void checkPriority(String priority) throws Exception {
        if (priority.charAt(0) != 'p' || priority.charAt(1) != ' ') {
            throw new DeadlineCreationFormatNotFollowedException();
        }
        if (priority.substring(2).isBlank()) {
            throw new TaskCreationPriorityMissingException();
        }
    }

    /**
     * Checks if the due time is provided in the correct format, throws an exception if wrong format is used.
     *
     * @param dueTime String entered by user for due time.
     * @throws Exception If wrong format is used.
     */
    private void checkDueTime(String dueTime) throws Exception {
        if (dueTime.charAt(0) != 't' || dueTime.charAt(1) != ' ') {
            throw new DeadlineCreationFormatNotFollowedException();
        }
        if (dueTime.substring(2).isBlank()) {
            throw new DeadlineCreationDueTimeMissingException();
        }
    }

    @Override
    public void executeCommand(TaskList taskList, Ui ui)   {
        taskList.addTask(newDeadline, ui);
    }

}
