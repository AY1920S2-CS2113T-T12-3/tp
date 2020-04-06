package command;

import exception.command.EventCreationEndTimeMissingException;
import exception.command.EventCreationFormatNotFollowedException;
import exception.command.EventCreationStartTimeMissingException;
import exception.command.EventDetailsNotProvidedException;
import exception.command.TaskCreationDateMissingException;
import exception.command.TaskCreationDescriptionMissingException;
import exception.command.TaskCreationPriorityMissingException;
import task.Event;
import task.TaskList;
import ui.Ui;

import java.time.LocalDate;

//@@author GanapathySanathBalaji
/**
 * This command is used to add new events to the TaskList.
 */
public class AddEventCommand extends Command {

    public static final String START_TIME_AFTER_END_TIME_ERROR_MESSAGE = "Start time after end time exception "
            + "not thrown";
    public static final String DATE_BEFORE_CURRENT_DATE_ERROR_MESSAGE = "Date past current day exception not thrown";
    public static final String SLASH_SYMBOL = "/";

    /** The new event to be added. */
    Event newEvent;

    /**
     * Constructor for the AddCommand Object.
     * Abstracts out the details from the user input and uses it to create a new event object.
     *
     * @param eventDetails The array contains the information regarding the new event to be added.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used to create an event.
     */
    public AddEventCommand(String[] eventDetails, boolean isOneWordCommand) throws Exception {
        if (isOneWordCommand) {
            throw new EventDetailsNotProvidedException();
        }
        String[] details = eventDetails[1].split(SLASH_SYMBOL);
        isCorrectFormat(details);
        String description = details[0];
        String date = details[1].substring(2);
        String startTime = details[2].substring(2);
        String endTime = details[3].substring(2);
        String priority = details[4].substring(2);
        newEvent =  new Event(description,date,startTime,endTime,priority);
        assert !newEvent.getStartTime().isAfter(newEvent.getEndTime()) : START_TIME_AFTER_END_TIME_ERROR_MESSAGE;
        assert !newEvent.getDate().isBefore(LocalDate.now()) : DATE_BEFORE_CURRENT_DATE_ERROR_MESSAGE;
    }

    /**
     * Checks if the correct format is used to create an event, if not an exception is thrown.
     *
     * @param details Details entered by user.
     * @throws Exception If any of the fields are missing.
     */
    private void isCorrectFormat(String[] details) throws Exception {
        if (details.length != 5) {
            throw new EventCreationFormatNotFollowedException();
        }
        try {
            String description = details[0];
            checkDescription(description);
            String date = details[1];
            checkDate(date);
            String startTime = details[2];
            checkStartTime(startTime);
            String endTime = details[3];
            checkEndTime(endTime);
            String priority = details[4];
            checkPriority(priority);
        } catch (IndexOutOfBoundsException e) {
            throw new EventCreationFormatNotFollowedException();
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
            throw new EventCreationFormatNotFollowedException();
        }
        if (priority.substring(2).isBlank()) {
            throw new TaskCreationPriorityMissingException();
        }
    }

    /**
     * Checks if the end time is provided in the correct format, throws an exception if wrong format is used.
     *
     * @param endTime String entered by user for end time.
     * @throws Exception If wrong format is used.
     */
    private void checkEndTime(String endTime) throws Exception {
        if (endTime.charAt(0) != 'e' || endTime.charAt(1) != ' ') {
            throw new EventCreationFormatNotFollowedException();
        }
        if (endTime.substring(2).isBlank()) {
            throw new EventCreationEndTimeMissingException();
        }
    }

    /**
     * Checks if the start time is provided in the correct format, throws an exception if wrong format is used.
     *
     * @param startTime String entered by user for start time.
     * @throws Exception If wrong format is used.
     */
    private void checkStartTime(String startTime) throws Exception {
        if (startTime.charAt(0) != 's' || startTime.charAt(1) != ' ') {
            throw new EventCreationFormatNotFollowedException();
        }
        if (startTime.substring(2).isBlank()) {
            throw new EventCreationStartTimeMissingException();
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
            throw new EventCreationFormatNotFollowedException();
        }
        if (date.substring(2).isBlank()) {
            throw new TaskCreationDateMissingException();
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

    @Override
    public void executeCommand(TaskList taskList, Ui ui)  {
        taskList.addTask(newEvent, ui);
    }

}
