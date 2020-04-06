package task;

import exception.command.DescriptionContainsInvalidCharacterException;
import exception.command.EmptyDescriptionException;
import exception.command.EventStartTimeAfterEndTimeException;
import exception.command.InvalidDateException;
import exception.command.InvalidEndTimeException;
import exception.command.InvalidStartTimeException;
import exception.command.SearchKeywordEmptyException;
import exception.command.TaskDateBeforeCurrentDateException;
import exception.command.TaskPriorityNotIntegerException;
import ui.Constants;
import ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ui.Constants.ENTER_NEW_DESCRIPTION_MESSAGE;
import static ui.Constants.SPACE;

//@@author GanapathySanathBalaji
/**
 * Represents an event and contains the related functions.
 */
public class Event extends Task {

    public static final String EMPTY_DESCRIPTION_MESSAGE = "New description entered by user while editing "
            + "the task is empty";
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Setter for priority of the deadline.
     *
     * @param priority The new priority of the event.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Getter function for Start Time of Event.
     *
     * @return Start time of event.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Getter function for End Time of Event.
     *
     * @return End time of event.
     */
    public LocalTime getEndTime() {
        return endTime;
    }


    /**
     * Constructor for Event Class.
     *
     * @param description Description of the event.
     * @param date Date of specified Event.
     * @param startTime Start time of specified event.
     * @param endTime End time of specified event.
     * @param priority Priority of specified event.
     * @throws Exception If wrong format is used for date, time or priority fields.
     */
    public Event(String description, String date, String startTime, String endTime, String priority)
            throws Exception {
        taskType = TaskType.Event;
        parseDescription(description);
        parseDate(date);
        parseStartTime(startTime);
        parseEndTime(endTime);
        if (this.startTime.isAfter(this.endTime)) {
            LOGGER.log(Level.INFO, Constants.START_TIME_AFTER_END_TIME);
            throw new EventStartTimeAfterEndTimeException();
        }
        parsePriority(priority);
    }

    /**
     * Parses the priority from the string entered by user for the priority field.
     *
     * @param priority String entered by user for the priority field.
     * @throws Exception If the provided priority isn't an integer.
     */
    private void parsePriority(String priority) throws Exception {
        try {
            this.priority = Integer.parseInt(priority.strip());
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO, Constants.PRIORITY_NOT_INTEGER);
            throw new TaskPriorityNotIntegerException();
        }
    }

    /**
     * Parses the End time from the string entered by user for the endTime field.
     *
     * @param endTime String entered by user for the endTime field.
     * @throws Exception If the provided end time isn't valid.
     */
    private void parseEndTime(String endTime) throws Exception {
        try {
            this.endTime = LocalTime.parse(endTime.strip());
        } catch (DateTimeParseException e) {
            LOGGER.log(Level.INFO, Constants.INVALID_END_TIME);
            throw new InvalidEndTimeException();
        }
    }

    /**
     * Parses the End time from the string entered by user for the startTime field.
     *
     * @param startTime String entered by user for the startTime field.
     * @throws Exception If the provided start time isn't valid.
     */
    private void parseStartTime(String startTime) throws Exception {
        try {
            this.startTime = LocalTime.parse(startTime.strip());
        } catch (DateTimeParseException e) {
            LOGGER.log(Level.INFO, Constants.INVALID_START_TIME);
            throw new InvalidStartTimeException();
        }
    }

    /**
     * Parses the Date from the string entered by user for the date field.
     *
     * @param date String entered by user for the date field.
     * @throws Exception If the provided date isn't valid or is a past date.
     */
    private void parseDate(String date) throws Exception {
        try {
            this.date = LocalDate.parse(date.strip());
        } catch (DateTimeParseException e) {
            LOGGER.log(Level.INFO, Constants.INVALID_DATE);
            throw new InvalidDateException();
        }
        if (this.date.isBefore(LocalDate.now())) {
            LOGGER.log(Level.INFO, Constants.DATE_AFTER_CURRENT_DATE);
            throw new TaskDateBeforeCurrentDateException();
        }
    }

    /**
     * Parses the description from the string entered by user for the description field.
     *
     * @param description String entered by user for the description field.
     * @throws Exception If the description of the task provided is invalid.
     */
    private void parseDescription(String description) throws Exception {

        if (description.isBlank()) {
            throw new EmptyDescriptionException();
        }
        if (description.contains(Character.toString('/')) || description.contains(Character.toString('#'))) {
            throw new DescriptionContainsInvalidCharacterException();
        }
        this.description = description;
    }

    /**
     * Returns the information related to information in form of a string.
     *
     * @return eventInfo Contains information related to the event.
     */
    public String getTaskInformation() {
        String eventInfo = Constants.EVENT_SYMBOL + description + Constants.AT
                + date.format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN)) + Constants.FROM_PLAIN
                + startTime.toString() + Constants.TO + endTime.toString() + Constants.WITH_PRIORITY + priority;
        return eventInfo;
    }

    /**
     * Returns the number of days left till the event.
     *
     * @return Number of days till event.
     */
    @Override
    public long numberOfDaysLeft() {
        return ChronoUnit.DAYS.between(LocalDate.now(),this.date);
    }

    @Override
    public String getCalendarTaskDetails() {
        String details = Constants.EVENT_SYMBOL + this.description;
        if (details.length() > 25) {
            details = details.substring(0, 22);
            details = details + "...";
        } else {
            StringBuilder detailsBuilder = new StringBuilder(details);
            while (detailsBuilder.length() < 25) {
                detailsBuilder.append(SPACE);
            }
            details = detailsBuilder.toString();
        }
        return details;
    }

    /**
     * Returns the priority of the specified event.
     *
     * @return Priority of event.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the date of the event.
     *
     * @return Date of event.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Used to identify if the string contains the keyword specified in its description.
     *
     * @param keyword The keyword to be matched with the description.
     * @return containsKeyword Indicates the presence/absence of keyword in the event's description.
     * @throws Exception If keyword entered is empty.
     */
    public boolean hasKeyword(String keyword) throws Exception {
        if (keyword.equals(Constants.EMPTY_STRING)) {
            LOGGER.log(Level.INFO, Constants.SEARCH_KEYWORD_EMPTY);
            throw new SearchKeywordEmptyException();
        }
        boolean containsKeyword = description.toLowerCase().contains(keyword.toLowerCase());
        return containsKeyword;
    }

    /**
     * Returns the event in the format used to store it in the data file.
     *
     * @return formattedEventDetails Contains the event details in the required format.
     */
    public String getFormattedDetails() {
        String formattedEventDetails = Constants.EVENT_IDENTIFIER + Constants.DELIMITER + description
                + Constants.DELIMITER + date + Constants.DELIMITER + startTime + Constants.DELIMITER + endTime
                + Constants.DELIMITER + priority + Constants.NEW_LINE_CHARACTER;
        return formattedEventDetails;
    }

    /**
     * Edits the event at the index specified.
     *
     * @param ui Used to interact with the user.
     * @return Newly updated event.
     */
    public Event editEvent(Ui ui) {
        printOptionsToEdit(ui);
        int fieldToBeEdited;
        fieldToBeEdited = getFieldToBeEdited(ui);
        switch (fieldToBeEdited) {
        case Constants.EDIT_DESCRIPTION:
            editDescription(ui);
            break;
        case Constants.EDIT_DATE:
            editDate(ui);
            break;
        case Constants.EDIT_START_TIME:
            editStartTime(ui);
            break;
        case Constants.EDIT_END_TIME:
            editEndTime(ui);
            break;
        case Constants.EDIT_PRIORITY:
            editPriority(ui);
            break;
        default:
            LOGGER.log(Level.SEVERE, Constants.WRONG_OPTION);
            ui.printMessage(Constants.ERROR_MESSAGE);
            break;
        }
        printUpdatedDetails(ui);
        return this;
    }

    /**
     * Used to edit the priority field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editPriority(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(Constants.ENTER_NEW_PRIORITY_MESSAGE);
            String newPriorityString = ui.getUserIn();
            try {
                parsePriority(newPriorityString);
            } catch (Exception e) {
                LOGGER.log(Level.INFO, Constants.INVALID_PRIORITY_VALUE);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the endTime field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editEndTime(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(Constants.ENTER_NEW_END_TIME_MESSAGE);
            String newEndTimeString = ui.getUserIn();
            try {
                parseEndTime(newEndTimeString);
                if (this.endTime.isBefore(this.startTime)) {
                    LOGGER.log(Level.INFO, Constants.START_TIME_AFTER_END_TIME);
                    throw new EventStartTimeAfterEndTimeException();
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, Constants.INVALID_END_TIME_ENTERED);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the startTime field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editStartTime(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(Constants.ENTER_NEW_START_TIME_MESSAGE);
            String newStartTimeString = ui.getUserIn();
            try {
                parseStartTime(newStartTimeString);
                if (this.endTime.isBefore(this.startTime)) {
                    LOGGER.log(Level.INFO, Constants.START_TIME_AFTER_END_TIME);
                    throw new EventStartTimeAfterEndTimeException();
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, Constants.INVALID_START_TIME_ENTERED);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the date field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editDate(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(Constants.ENTER_NEW_DATE_MESSAGE);
            String newDateString = ui.getUserIn();
            try {
                parseDate(newDateString);
                if (this.date.isBefore(LocalDate.now())) {
                    LOGGER.log(Level.INFO, Constants.DATE_AFTER_CURRENT_DATE);
                    throw new TaskDateBeforeCurrentDateException();
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, Constants.INVALID_DATE_ENTERED);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the description field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editDescription(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(ENTER_NEW_DESCRIPTION_MESSAGE);
            String newDescription = ui.getUserIn();
            try {
                parseDescription(newDescription);
            } catch (Exception e) {
                LOGGER.log(Level.INFO, EMPTY_DESCRIPTION_MESSAGE);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Returns an integer denoting the field selected to be edited later.
     *
     * @param ui Used to interact with the user.
     * @return fieldToBeEdited Corresponds to the field to be edited.
     */
    private int getFieldToBeEdited(Ui ui) {
        int fieldToBeEdited = 0;
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            try {
                fieldToBeEdited = Integer.parseInt(ui.getUserIn());
                boolean isInvalidOption = fieldToBeEdited > 5 || fieldToBeEdited <= 0;
                if (isInvalidOption) {
                    throw new Exception();
                }
            } catch (Exception exception) {
                LOGGER.log(Level.INFO, Constants.INVALID_OPTION_ENTERED);
                ui.printMessage(Constants.ENTER_VALID_NUMBER_FROM_LIST_MESSAGE);
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
        return fieldToBeEdited;
    }

    /**
     * Prints the updated details of the event after an edit command.
     *
     * @param ui Used to interact with user.
     */
    private void printUpdatedDetails(Ui ui) {
        ui.printMessage(Constants.UPDATED_DETAILS);
        ui.printMessage(this.getTaskInformation());
    }

    /**
     * Prints the list of fields that could be edited as a list.
     *
     * @param ui Used to interact with user.
     */
    private void printOptionsToEdit(Ui ui) {
        ui.printLine();
        ui.printMessage(Constants.EVENT_DETAILS_AS_FOLLOWS_MESSAGE);
        ui.printMessage(this.getTaskInformation());
        ui.printMessage(Constants.ASK_FOR_OPTION_MESSAGE);
        ui.printMessage(Constants.OPTION_TO_EDIT_DESCRIPTION);
        ui.printMessage(Constants.OPTION_TO_EDIT_DATE);
        ui.printMessage(Constants.OPTION_TO_EDIT_START_TIME);
        ui.printMessage(Constants.OPTION_TO_EDIT_END_TIME);
        ui.printMessage(Constants.OPTION_TO_EDIT_PRIORITY);
        ui.printEmptyLine();
    }
}
