package parser;

import command.AddDeadlineCommand;
import command.AddEventCommand;
import command.CalendarCommand;
import command.ClearCommand;
import command.Command;
import command.CountdownCommand;
import command.CreateScheduleCommand;
import command.DeleteCommand;
import command.DoneCommand;
import command.EditCommand;
import command.HelpCommand;
import command.PriorityViewCommand;
import command.SearchCommand;
import command.ViewCommand;

import static ui.Constants.MULTIPLE_WHITE_SPACES;

//@@author GanapathySanathBalaji
/**
 * This class is used to parse the user input into executable commands.
 */
public class Parser {

    public static final String ADD_DEADLINE_COMMAND = "deadline";
    public static final String ADD_EVENT_COMMAND = "event";
    public static final String VIEW_COMMAND = "view";
    public static final String PRIORITY_VIEW_COMMAND = "priority_view";
    public static final String COUNTDOWN_VIEW_COMMAND = "countdown";
    public static final String CLEAR_COMMAND = "clear";
    public static final String SEARCH_COMMAND = "search";
    public static final String DELETE_COMMAND = "delete";
    public static final String EDIT_COMMAND = "edit";
    public static final String EMPTY_COMMAND = "";
    public static final String HELP_COMMAND = "help";
    public static final String CREATE_SCHEDULE_COMMAND = "schedule";
    public static final String DONE_COMMAND = "done";
    public static final  String CALENDAR_COMMAND = "calendar";


    /**
     * This method takes in the user input parses it and returns the command to be executed.
     * @param fullCommand THe entire line of command entered by the user.
     * @return command The command parsed form the user input.
     * @throws Exception If the wrong command/ wrong format is given by the user as an input.
     */
    public Command parseCommand(String fullCommand) throws Exception {

        String[] commandSplit = fullCommand.split(MULTIPLE_WHITE_SPACES,2);
        String commandType = commandSplit[0];
        Command command;
        boolean isOneWordCommand = commandSplit.length == 1 || commandSplit[1].isBlank();
        switch (commandType) {
        case ADD_DEADLINE_COMMAND:
            command = new AddDeadlineCommand(commandSplit, isOneWordCommand);
            break;
        case ADD_EVENT_COMMAND:
            command = new AddEventCommand(commandSplit, isOneWordCommand);
            break;
        case EDIT_COMMAND:
            command = new EditCommand(commandSplit, isOneWordCommand);
            break;
        case VIEW_COMMAND:
            command = new ViewCommand(isOneWordCommand);
            break;
        case PRIORITY_VIEW_COMMAND:
            command = new PriorityViewCommand(isOneWordCommand);
            break;
        case COUNTDOWN_VIEW_COMMAND:
            command = new CountdownCommand(isOneWordCommand);
            break;
        case CLEAR_COMMAND:
            command = new ClearCommand(isOneWordCommand);
            break;
        case SEARCH_COMMAND:
            command = new SearchCommand(commandSplit, isOneWordCommand);
            break;
        case DELETE_COMMAND:
            command = new DeleteCommand(commandSplit, isOneWordCommand);
            break;
        case HELP_COMMAND:
            command = new HelpCommand(isOneWordCommand);
            break;
        case CREATE_SCHEDULE_COMMAND:
            command = new CreateScheduleCommand(isOneWordCommand, commandSplit);
            break;
        case DONE_COMMAND:
            command = new DoneCommand(commandSplit,isOneWordCommand);
            break;
        case CALENDAR_COMMAND:
            command = new CalendarCommand(isOneWordCommand);
            break;
        case EMPTY_COMMAND:
            throw new Exception("Empty Line entered, Please enter a valid line");
            // Break statement can't be reached if added
        default:
            throw new Exception("Invalid command entered, Please enter a valid command");
            // Break statement can't be reached if added
        }
        return command;
    }

}
