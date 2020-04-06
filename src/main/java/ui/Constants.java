package ui;

import java.io.File;

/**
 * This class contains all the constants required for Ui.
 */
public class Constants {
    public static final String FILE_PATH_STUDYAREAS = "library" + File.separator + "locations.txt";
    public static final String FILE_PATH_DICTIONARY = "library" + File.separator + "dictionary.txt";
    public static final String MISSING_STUDY_AREA_DATA = "locations.txt is missing";
    public static final String BYE_COMMAND = "bye";
    public static final String LINE = "_______________________________________________________________________________"
            + "_________________";
    public static final int MAX_LINE_LENGTH = 58;
    public static final String FLAG = "-";
    public static final String MULTIPLE_WHITE_SPACES = "\\s+";
    public static final String DUPLICATE_FLAGS = "Duplicate flags entered!";
    public static final String SIZE_FLAG = "-s";
    public static final String PORTS_FLAG = "-p";
    public static final String INDOOR_FLAG = "-i";
    public static final String OUTDOOR_FLAG = "-o";
    public static final String NOT_INTEGER = "Argument used after size flag \"-s\" is not an integer";
    public static final String WRONG_FLAG_USAGE = "Flags indicated are wrongly used. Please enter \"help\" for the"
            + " supported flags!";
    public static final String SPACE = " ";
    public static final String WRONG_FLAG_ARGUMENT_POSITION = "Flags are to be used only after location";
    public static final String START_STUDY_AREA_SEARCH = "Please enter the location for your desired study area. "
            + "Enter \"help\" for a list of supported flags. Flags should only come after location, if a criteria for"
            + " location is entered. When you are done with the search, enter \"bye\".";
    public static final String PROMPT_USER = "Please enter the location for your desired study area.";
    public static final String FLAGS = "\t Here is a list of supported flags!" + System.lineSeparator()
            + "\t -p for study"
            + " areas with ports" + System.lineSeparator() + "\t -i for study areas that are indoors"
            + System.lineSeparator() + "\t -o for study areas that are outdoors" + System.lineSeparator() + "\t "
            + "-s {size} for maximum number of pax";
    public static final String AVAILABLE_STUDY_AREAS = "Here are the available study areas!";
    public static final String EMPTY_LIST = "Oops! Based on your criteria we were not able to find a compatible study"
            + " area!";
    public static final String ONLY_FLAG = "Please enter the flag along with \"-\"";
    public static final String INCONSISTENT_DATA_STORAGE = "Data is wrongly stored in locations.txt";
    public static final String HELP_COMMAND = "help";
    public static final String TAB = "\t ";
    public static final String NO_SIZE_INDICATED = "Max Size is not indicated. Please indicate accordingly!";
    public static final String END_MESSAGE = "Thank you for using our study area search service!";
    public static final String START_MESSAGE = TAB + "Welcome to OrgaNice! Below would be a list of commands useful "
            + "for you!";
    public static final String GOODBYE_MESSAGE = "  Goodbye! Hope to see you again!";
    public static final String EMPTY_LOCATION = "Location entered is empty! Please type a location to search for "
            + "StudyAreas!";
    public static final String NON_POSITIVE_INTEGER = "Integer entered cannot be zero or negative!";
    public static final String HELP_DESCRIPTION_23 = TAB + "*All timing should follow 24 hour clock";
    public static final String HELP_DESCRIPTION_22 = TAB + "*All dates should follow YYYY-MM-DD format";
    public static final String HELP_DESCRIPTION_21 = TAB + "Notes:";
    public static final String HELP_DESCRIPTION_20 = TAB + "notes ------------------------------------- Enter Notes";
    public static final String HELP_DESCRIPTION_19 = TAB + "study ------------------------------------- Enter Study "
            + "Area search interface";
    public static final String HELP_DESCRIPTION_18 = TAB + "bye --------------------------------------- Terminate task"
            + " interface";
    public static final String HELP_DESCRIPTION_17 = TAB + "help -------------------------------------- View List Of "
            + "Commands Supported";
    public static final String HELP_DESCRIPTION_16 = TAB + "schedule <number of task to be scheduled> - Schedule tasks";
    public static final String HELP_DESCRIPTION_15 = TAB + "done <index of task> ---------------------- Mark the "
            + "deadline as done";
    public static final String HELP_DESCRIPTION_14 = TAB + "edit <index of task> ---------------------- Edit the task";
    public static final String HELP_DESCRIPTION_13 = TAB + "delete <index of task> -------------------- Delete the "
            + "task";
    public static final String HELP_DESCRIPTION_12 = TAB + "search <keyword found in task> ------------ View existing "
            + "task that contains the keyword";
    public static final String HELP_DESCRIPTION_11 = TAB + "clear ------------------------------------- Delete"
            + " all tasks";
    public static final String HELP_DESCRIPTION_10 = TAB + "countdown --------------------------------- View existing"
            + " tasks based on days left";
    public static final String HELP_DESCRIPTION_9 = TAB + "priority_view ----------------------------- View existing "
            + "tasks based on priority";
    public static final String HELP_DESCRIPTION_8 = TAB + "view -------------------------------------- View existing"
            + " events";
    public static final String HELP_DESCRIPTION_7 = TAB + "------------------------------------------- Create a new "
            + "deadline";
    public static final String HELP_DESCRIPTION_5 = TAB + "deadline <deadline details> /d <date> /t <due time> /p "
            + "<priority of deadline>";
    public static final String HELP_DESCRIPTION_4 = TAB + "------------------------------------------- Create a new "
            + "event";
    public static final String HELP_DESCRIPTION_3 = TAB + "event <event details> /d <date> /s <start time> "
            + "/e <end time> /p <priority of event>";
    public static final String HELP_DESCRIPTION_2 = TAB + "Please enter the keywords followed by the information"
            + " shown in the brackets";
    public static final String HELP_DESCRIPTION_1 = TAB + "OrgaNice! Supports the following commands";
    //@@author NizarMohd-reused
    //Reused from https://www.netclipart.com/isee/iRwmhJb_bt21-rj-transparent-background/ and https://asciiart.club/
    //Image for public static final String DAB is obtained from the first link and then generated in second link.
    public static final String DAB = "\t ``````````````````````````````````````````````````````````"
            + System.lineSeparator()
            + "\t ````````````````````````````````:v(v'`````````````````````" + System.lineSeparator()
            + "\t ```````````````````````````,)4|ex` `L}````````````````````" + System.lineSeparator()
            + "\t `````````````````````````!s\"'h `M:   ^z_;)T```````````````" + System.lineSeparator()
            + "\t `````````````````````````Z   u|}Z:        \"}``````````````" + System.lineSeparator()
            + "\t ``````````````````````:=?)                'B?L'```````````" + System.lineSeparator()
            + "\t `````````````````````'Z                    ;Yp\"```````````" + System.lineSeparator()
            + "\t `````````````````````.e                      ?_```````````" + System.lineSeparator()
            + "\t ```````````````````'QDGH                    .5````````````" + System.lineSeparator()
            + "\t ````````````````````I#g'         '_`        ||````````````" + System.lineSeparator()
            + "\t ```````````:mX_``````YhL`      `'q!`   ?     h````````````" + System.lineSeparator()
            + "\t ```````````'Qbs)|L=_V\" 'Y}     ^'q@&b=c=_`  ,Z````````````" + System.lineSeparator()
            + "\t ````````````q>     'T,   ,o\"    ;\"@c.   .sVx~`````````````" + System.lineSeparator()
            + "\t ````````````c!             \"bh` `,p       z:``````````````" + System.lineSeparator()
            + "\t `````````````q.              ngDQmh8s     X'``````````````" + System.lineSeparator()
            + "\t ``````````````LY\"             :n}>``b;   _V```````````````" + System.lineSeparator()
            + "\t ````````````````q?,                ?;   \"V````````````````" + System.lineSeparator()
            + "\t ``````````````KvR                  '  )x_`````````````````" + System.lineSeparator()
            + "\t ``````````````zjL                  GLY\"```````````````````" + System.lineSeparator()
            + "\t ```````````````M                 .I)``````````````````````" + System.lineSeparator()
            + "\t ```````````````Lz                `D:``````````````````````" + System.lineSeparator()
            + "\t ``````````````vu`    (I)_;\"\".      P.`````````````````````" + System.lineSeparator()
            + "\t ``````````````p     :X.':^,\"=n    \"q``````````````````````" + System.lineSeparator()
            + "\t `````````````)0X?^:)I````````m'   :j``````````````````````" + System.lineSeparator()
            + "\t `````````````.IGD8k'`````````<&G55M```````````````````````" + System.lineSeparator()
            + "\t ``````````````````````````````````````````````````````````";
    //@@author

    //@@author NizarMohd-reused
    //Reused logo from http://patorjk.com/software/taag/#p=display&f=Graffiti&t=TypeSomething with minor
    // modifications. The website above allows for generation of fonts in ascii format. Therefore, logo is
    // generated from the service provided by the website.
    public static final String LOGO = "_______/\\\\\\\\\\___________________________________________________"
        + "__/\\\\\\\\\\_____/\\\\\\__"
        + "__________________________________________/\\\\\\____________" +  System.lineSeparator()
        + "______/\\\\\\///\\\\\\__________________________________________________\\/\\\\\\\\\\\\___\\/\\\\\\_"
        + "_________________________________________/\\\\\\\\\\\\\\_________" +  System.lineSeparator()
        + "_____/\\\\\\/__\\///\\\\\\____________________/\\\\\\\\\\\\\\\\___________________\\/\\\\\\/\\\\\\_"
        + "_\\/\\\\\\___/\\\\\\__________________________________/\\\\\\\\\\\\\\\\\\_______"
        +  System.lineSeparator()
        + "_____/\\\\\\______\\//\\\\\\___/\\\\/\\\\\\\\\\\\\\____/\\\\\\////\\\\\\___/\\\\\\\\\\\\\\\\\\___"
        + "__\\/\\\\\\//\\\\\\_\\/\\\\\\__\\///_______/\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\__"
        + "_\\//\\\\\\\\\\\\\\_______" +  System.lineSeparator()
        + "_____\\/\\\\\\_______\\/\\\\\\__\\/\\\\\\/////\\\\\\__\\//\\\\\\\\\\\\\\\\\\__\\////////\\\\\\___"
        + "_\\/\\\\\\\\//\\\\\\\\/\\\\\\___/\\\\\\____/\\\\\\//////_____/\\\\\\/////\\\\\\___\\//\\\\\\\\\\____"
        + "___" +  System.lineSeparator()
        + "______\\//\\\\\\______/\\\\\\___\\/\\\\\\___\\///____\\///////\\\\\\____/\\\\\\\\\\\\\\\\\\\\__"
        + "_\\/\\\\\\_\\//\\\\\\/\\\\\\__\\/\\\\\\___/\\\\\\___________/\\\\\\\\\\\\\\\\\\\\\\_____\\//\\\\\\__"
        + "_____" +  System.lineSeparator()
        + "________\\///\\\\\\__/\\\\\\_____\\/\\\\\\___________/\\\\_____\\\\\\___/\\\\\\/////\\\\\\__"
        + "_\\/\\\\\\__\\//\\\\\\\\\\\\__\\/\\\\\\__\\//\\\\\\_________\\//\\\\///////_______\\///_______"
        +  System.lineSeparator()
        + "____________\\///\\\\\\\\\\/______\\/\\\\\\__________\\//\\\\\\\\\\\\\\\\__"
        + "_\\//\\\\\\\\\\\\\\\\/\\\\"
        + "_\\/\\\\\\___\\//\\\\\\\\\\__\\/\\\\\\___\\///\\\\\\\\\\\\\\\\___\\//\\\\\\\\\\\\\\\\\\\\_____"
        + "_/\\\\\\_____" +  System.lineSeparator()
        + "______________\\/////________\\///____________\\////////_____\\////////\\//___\\///_____\\/////__"
        +  "_\\///______\\////////_____\\//////////______\\///_____";
    //@@author

    public static final String NON_POSITIVE_INTEGER_LOG = "User entered a non positive integer";
    public static final String NON_INTEGER_LOG = "User entered an invalid number for integer input";

    public static final String DUPLICATE_FLAGS_LOG = "Duplicate flags entered by user";
    public static final String IDENTIFIER_MISSING_LOG = "Identifier not entered with flag by user";
    public static final String NO_SIZE_INDICATED_LOG = "no string exist after \"-s\"";
    public static final String WRONG_FLAG_LOG = "Wrong flag used by user while searching for study areas";
    public static final String FLAG_MISPLACED_LOG = "Flag is placed in the wrong position in the user input";
    public static final String NEW_TASK_ADDED_MESSAGE = "A new task with the following information has been added.";
    public static final String TASK_LIST_AS_FOLLOWS = "Here is the list of tasks added so far:";
    public static final String CLOSING_BRACKET = ") ";
    public static final String SEARCH_EMPTY_MESSAGE = "No matched tasks found.";
    public static final String TASK_AT_INDEX_DELETED_MESSAGE = "Noted! I have removed this task:";
    public static final String INDEX_TO_BE_DELETED_OUT_OF_BOUNDS_LOG = "Index specified to be deleted is out of bounds";
    public static final String RE_ENTER_VALID_INDEX_TO_DELETE_MESSAGE = "Invalid index entered. Please enter a valid"
            + " index to be deleted";
    public static final String TASK_AT_INDEX_EDITED_MESSAGE = "The task at the mentioned index has been "
            + "edited successfully";
    public static final String RE_ENTER_VALID_INDEX_TO_EDIT_MESSAGE = "Invalid index entered. Please enter a"
            + " valid index to be edited";
    public static final String RE_ENTER_VALID_INDEX_TO_MARK_AS_DONE_MESSAGE = "Invalid index entered. Please enter a"
            + " valid index to be marked as done";
    public static final String DEADLINE_MARKED_AS_DONE = "Nice! I've marked this deadline as done!";
    public static final String INVALID_TASK_TYPE_LOG = "Task type of the task to be edited not recognized";
    public static final String ERROR_ENCOUNTERED_DURING_EXECUTION_MESSAGE = "Error encountered during execution";
    public static final String TASK_LIST_CLEARED_MESSAGE = "The list of tasks is cleared";
    public static final String LIST_SORTED_BY_PRIORITY_MESSAGE = "Here is the list of tasks added so far displayed "
            + "in decreasing order of priority:";
    public static final String LIST_SORTED_ON_DAYS_LEFT_MESSAGE = "Here is the list of tasks with sorted based"
            + " on the number of days left:";
    public static final String ARROW_SYMBOL = " ---> ";
    public static final String DAYS_LEFT = " day(s) left";
    public static final String FROM = " is scheduled from ";
    public static final String TO = " to ";
    public static final String WRONG_FORMAT_MESSAGE = "Please follow the format specified. Renter details:";
    public static final String ENTER_DETAILS = "Enter details for task ";
    public static final String COLON = ":";
    public static final String FORWARD_SLASH = "/";
    public static final String SCHEDULABLE_TASK_FORMAT = "<task name> /f <Time to finish task in days>"
            + " /d <Number of days left from current day to finish it>";
    public static final String ENTER_TASKS_IN_THE_FOLLOWING_FORMAT = "Enter tasks in the following format:";
    public static final String DETAILS_CAPTURED_SUCCESSFULLY = "Details captured successfully.";
    public static final int EDIT_DESCRIPTION = 1;
    public static final int EDIT_DATE = 2;
    public static final int EDIT_START_TIME = 3;
    public static final int EDIT_END_TIME = 4;
    public static final int EDIT_PRIORITY = 5;
    public static final String ERROR_MESSAGE = "Error encountered during execution";
    public static final String DATE_PATTERN = "MMM d yyyy";
    public static final String EVENT_SYMBOL = "[E] ";
    public static final String AT = " at ";
    public static final String WITH_PRIORITY = " with priority ";
    public static final String EMPTY_STRING = "";
    public static final String DELIMITER = "#";
    public static final String NEW_LINE_CHARACTER = System.lineSeparator();
    public static final String EVENT_IDENTIFIER = "E";
    public static final String ENTER_NEW_PRIORITY_MESSAGE = "Enter new priority:";
    public static final String ENTER_NEW_END_TIME_MESSAGE = "Enter new End Time:";
    public static final String ENTER_NEW_START_TIME_MESSAGE = "Enter new Start Time:";
    public static final String ENTER_NEW_DATE_MESSAGE = "Enter new Date:";
    public static final String ENTER_NEW_DESCRIPTION_MESSAGE = "Enter new description:";
    public static final String ENTER_VALID_NUMBER_FROM_LIST_MESSAGE = "Please enter a valid number from the list";
    public static final String UPDATED_DETAILS = "Updated Details:";
    public static final String EVENT_DETAILS_AS_FOLLOWS_MESSAGE = "The event details are as follows:";
    public static final String ASK_FOR_OPTION_MESSAGE = "Which field of the event to edit?"
            + " (Enter Corresponding Number)";
    public static final String OPTION_TO_EDIT_DESCRIPTION = "1. Description";
    public static final String OPTION_TO_EDIT_DATE = "2. Date";
    public static final String OPTION_TO_EDIT_START_TIME = "3. Start Time";
    public static final String OPTION_TO_EDIT_END_TIME = "4. End Time";
    public static final String OPTION_TO_EDIT_PRIORITY = "5. Priority";
    public static final String START_TIME_AFTER_END_TIME = "Event start time after end time exception thrown";
    public static final String PRIORITY_NOT_INTEGER = "Task priority not integer exception thrown";
    public static final String INVALID_END_TIME = "Invalid end time exception thrown";
    public static final String INVALID_START_TIME = "Invalid start time exception thrown";
    public static final String INVALID_DATE = "Invalid date exception thrown";
    public static final String DATE_AFTER_CURRENT_DATE = "Date after current date exception thrown";
    public static final String SEARCH_KEYWORD_EMPTY = "Search keyword empty exception thrown";
    public static final String WRONG_OPTION = "Wrong option entered not handled by getFieldToBeEdited";
    public static final String INVALID_PRIORITY_VALUE = "Invalid priority value entered by user";
    public static final String INVALID_END_TIME_ENTERED = "Invalid end time entered by the user";
    public static final String INVALID_START_TIME_ENTERED = "Invalid start time entered by user";
    public static final String INVALID_DATE_ENTERED = "Invalid date entered by user";
    public static final String INVALID_OPTION_ENTERED = "Invalid option entered by user";
    public static final String FROM_PLAIN = " from ";
    public static final String FILE_PATH_EVENTS = "library" + File.separator + "taskList.txt";
    public static final String FILE_PATH_STUDY_AREAS = "library" + File.separator + "locations.txt";
    public static final String EXCEPTION_ENCOUNTERED_MESSAGE = "Exception encountered when Duke was constructed";
    public static final String DUKE_LOGGER_LOG = "dukeLogger.log";
    public static final String FILE_LOGGER_NOT_WORKING_MESSAGE = "File Logger not working";
    public static final String APPLICATION_STARTED_EXECUTION = "Application started Execution";
    public static final String APPLICATION_GOING_TO_EXIT = "Application is going to exit";
    public static final String TASK_MODE = "Application transitioning to task mode";
    public static final String APPLICATION_CLOSED_SUCCESSFULLY = "Application closed successfully";
    public static final String SHORT_DESCRIPTION = "Description of location is too short!";
    public static final String STUDY_AREA_COMMAND = "study";
    public static final String TASK_S_IN_YOUR_LIST = " task(s) in your list";
    public static final String NOW_YOU_HAVE = "Now you have ";
    public static final String SEARCH_LIST_MESSAGE = "The list of tasks containing the mentioned keyword in their"
            + " description are as follows:";



    public static final String NOTES_COMMAND = "notes";
    public static final String NOTES_WELCOME_MESSAGE = "Welcome to OrgaNice's Notes!\n"
            + "Notes are stored based on modules.\n"
            + "To get started: add a module, enter a module and start adding notes!";
    public static final String ADD_MODULE_MESSAGE = "[add modulecode] to add a module";
    public static final String REMOVE_MODULE_MESSAGE = "[remove modulecode] to add a module";
    public static final String ENTER_MODULE_MESSAGE = "[enter modulecode] to enter notes for its notes";
    public static final String LIST_MODULE_MESSAGE = "[list] to list modules";
    public static final String EXIT_MODULE_MESSAGE = "[exit] to go back to OrgaNice main page";
    public static final String HELP_MODULE_MESSAGE = "[help] to list all the commands again";
    public static final String INVALID_NOTES_COMMAND_MESSAGE = "Please enter a valid command.";

    public static final String LINE_BREAK = "______________________________";

    public static final String NOTES_PATH = "library/notes.txt";
    public static final String NOTES_FILE_NOT_FOUND = "No notes are created as of now. All notes will automatically"
            + "be saved.";
    public static final String DIVIDER = "-----------------------------------------------------------------------"
            + "---------------------------------------------------------------------------------------------------"
            + "---------------------------";
    public static final String[] DAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public static final String SPACES = "                       ";
    public static final String COL = "|";
    public static final String PADDING = "    ";
    public static final String PADDING1 = "                        ";
    public static final String PADDING2 = "   ";
    public static final String PADDING3 = "  ";
    public static final int MAX_COL = 7;
    public static final int MAX_ROW = 5;
    public static final int JAN = 1;
    public static final int DEC = 12;
    public static final int MAX_LIST_SIZE = 4;
    public static final String ENTER_DESIRED_MONTH = "Enter the month and year that you wish to see: ";
    public static final String NON_INTEGER_YEAR = "Input entered for Year is not an integer. Please re-enter the year";
    public static final String INVALID_YEAR = "Invalid Year";
    public static final String INVALID_MONTH = "Input entered for month is not an integer. Please re-enter the month";
    public static final String INVALID_MONTH_RANGE = "Invalid Month range used. Must be within 1 - 12";
    public static final String TASKS_FOR = "Tasks for: ";
    public static final String COMMA = ", ";
    public static final String MAP_CANNOT_BE_EMPTY = "Map cannot be empty";
    public static final String NOW = "now";
    public static final String YES = "[Y]";
    public static final String NO = "[N]";
    public static final String LIST_EMPTY_MESSAGE = "List of tasks is empty";
}
