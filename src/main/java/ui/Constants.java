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
    public static final String BYE_MESSAGE = "Bye!!!!!!";
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
    public static final String FLAGS = "Here is a list of supported flags!\n\t -p for study areas with ports\n\t"
            + " -i for study areas that are indoors\n\t -i for study areas that are outdoors\n\t "
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
    public static final String START_MESSAGE = "Welcome to OrgaNice! To start, enter \"task\" to start"
            + " your event list! If you are in the mood to mug and you"
            + " want to start your study area list, enter \"study\" !If"
            + " you want to exit, enter \"bye\" !";
    public static final String WRONG_INPUT = "Wrong input! Please enter either \"event\" or \"study\" only!";
    public static final String TASK_COMMAND = "task";
    public static final String STUDY_COMMAND = "study";
    public static final String GOODBYE_MESSAGE = "  Goodbye! Hope to see you again!";
    public static final String INTERMEDIATE_MESSAGE = "Please enter \"task\" to continue with your event list or"
            + " \"study\" to continue with your study area list. To leave, enter \"bye\".";
    public static final String EMPTY_LOCATION = "Location entered is empty! Please type a location to search for "
            + "StudyAreas!";
    public static final String NON_POSITIVE_INTEGER = "Integer entered cannot be zero or negative!";
    public static final String HELP_DESCRIPTION_20 = TAB + "*There are 4 levels of priority, with 1 being the most "
            + "urgent, and 4 being the least urgent";
    public static final String HELP_DESCRIPTION_19 = TAB + "*All timing should follow 24 hour clock";
    public static final String HELP_DESCRIPTION_18 = TAB + "*All dates should follow YYYY-MM-DD format";
    public static final String HELP_DESCRIPTION_17 = TAB + "Notes:";
    public static final String HELP_DESCRIPTION_16 = TAB + "bye --------------------------------------- Terminate task"
            + " interface";
    public static final String HELP_DESCRIPTION_15 = TAB + "help -------------------------------------- View List Of "
            + "Commands Supported";
    public static final String HELP_DESCRIPTION_14 = TAB + "edit <index number of task> --------------- Edit the task";
    public static final String HELP_DESCRIPTION_13 = TAB + "delete <index number of task> ------------- Delete the "
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
    public static final String DAB = "\t ``````````````````````````````````````````````````````````\n"
            + "\t ````````````````````````````````:v(v'`````````````````````\n"
            + "\t ```````````````````````````,)4|ex` `L}````````````````````\n"
            + "\t `````````````````````````!s\"'h `M:   ^z_;)T```````````````\n"
            + "\t `````````````````````````Z   u|}Z:        \"}``````````````\n"
            + "\t ``````````````````````:=?)                'B?L'```````````\n"
            + "\t `````````````````````'Z                    ;Yp\"```````````\n"
            + "\t `````````````````````.e                      ?_```````````\n"
            + "\t ```````````````````'QDGH                    .5````````````\n"
            + "\t ````````````````````I#g'         '_`        ||````````````\n"
            + "\t ```````````:mX_``````YhL`      `'q!`   ?     h````````````\n"
            + "\t ```````````'Qbs)|L=_V\" 'Y}     ^'q@&b=c=_`  ,Z````````````\n"
            + "\t ````````````q>     'T,   ,o\"    ;\"@c.   .sVx~`````````````\n"
            + "\t ````````````c!             \"bh` `,p       z:``````````````\n"
            + "\t `````````````q.              ngDQmh8s     X'``````````````\n"
            + "\t ``````````````LY\"             :n}>``b;   _V```````````````\n"
            + "\t ````````````````q?,                ?;   \"V````````````````\n"
            + "\t ``````````````KvR                  '  )x_`````````````````\n"
            + "\t ``````````````zjL                  GLY\"```````````````````\n"
            + "\t ```````````````M                 .I)``````````````````````\n"
            + "\t ```````````````Lz                `D:``````````````````````\n"
            + "\t ``````````````vu`    (I)_;\"\".      P.`````````````````````\n"
            + "\t ``````````````p     :X.':^,\"=n    \"q``````````````````````\n"
            + "\t `````````````)0X?^:)I````````m'   :j``````````````````````\n"
            + "\t `````````````.IGD8k'`````````<&G55M```````````````````````\n"
            + "\t ``````````````````````````````````````````````````````````";
            //@@author
}
