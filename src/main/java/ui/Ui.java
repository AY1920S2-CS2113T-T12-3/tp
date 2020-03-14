package ui;


import studyarea.StudyArea;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.System.lineSeparator;

/**
 * Contains functions used to interact with the user.
 *
 */
public class Ui {
    private final Scanner in;
    private final PrintStream out;

    public static final String FILE_PATH_EVENTS = "library" + File.separator + "eventList.txt";
    public static final String FILE_PATH_STUDYAREAS = "library" + File.separator + "locations.txt";
    public static final String FILE_PATH_DICTIONARY = "library" + File.separator + "dictionary.txt";
    public static final String MISSING_STUDY_AREA_DATA = "locations.txt is missing";
    public static final String BYE_COMMAND = "bye";
    public static final String BYE_MESSAGE = "Bye!!!!!!";
    public static final String LINE = "_______________________________________________________________________________"
            + "_____";
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
            + "area!";
    public static final String ONLY_FLAG = "Please enter the flag along with \"-\"";
    public static final String INCONSISTENT_DATA_STORAGE = "Data is wrongly stored in locations.txt";
    public static final String HELP_COMMAND = "help";
    public static final String TAB = "\t ";
    public static final String NO_SIZE_INDICATED = "Max Size is not indicated. Please indicate accordingly!";
    public static final String END_MESSAGE = "Thank you for using our study area search service!";
    public static final String START_MESSAGE = "Welcome to OrgaNice! To start, enter \"event\" to start\n"
            + " your event list! If you are in the mood to mug and you"
            + " want to start your study area list, enter \"study\" !If"
            + " you want to exit, enter \"bye\" !";
    public static final String WRONG_INPUT = "Wrong input! Please enter either \"event\" or \"study\" only!";
    public static final String EVENT_COMMAND = "event";
    public static final String STUDY_COMMAND = "study";
    public static final String GOODBYE_MESSAGE = "  Goodbye! Hope to see you again!";
    public static final String INTERMEDIATE_MESSAGE = "Please enter \"event\" to continue with your event list or"
            + " \"study\" to continue with your study area list. To leave, enter \"bye\".";
    public static final String EMPTY_LOCATION = "Location entered is empty! Please type a location to search for "
            + "StudyAreas!";

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


    /**
     * This is the constructor used to create the Ui class in Duke.run().
     */
    public Ui() {
        this(System.in, System.out);
    }

    /**
     * This constructor assigns IO stream to the attributes of Ui.
     *
     * @param in This is the Input Stream for Ui.
     * @param out This is the Output Stream for Ui.
     */
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Returns the mode (event features or StudyArea features or exit) based on User input.
     *
     * @return an integer which is assigned to each mode.
     */
    public int getMode() {
        String userIn = this.in.nextLine().toLowerCase();
        switch (userIn) {
        case EVENT_COMMAND :
            return 1;
        case STUDY_COMMAND :
            return 2;
        case BYE_COMMAND :
            return -1;
        default :
            return 0;
        }
    }

    /**
     * This method allows for other class to get User input.
     *
     * @return String input from User.
     */
    public String getUserIn() {
        return this.in.nextLine();
    }

    /**
     * This method closes the Input Stream after usage is completed.
     */
    public void close() {
        this.in.close();
    }

    /**
     * Prints a line made up of '_'.
     */
    public void printLine() {
        this.out.println(LINE);
    }


    /**
     * This method ensures that the message printed is within the standard length.
     *
     * @param message is the String that we intend to format to a standard length per line.
     */
    public void printMessage(String message) {
        if (message.equals(GOODBYE_MESSAGE + DAB)) {
            this.out.println(TAB + GOODBYE_MESSAGE);
            this.out.println(DAB);
        } else {
            this.out.println(formatMessage(message, MAX_LINE_LENGTH));
        }
    }

    /**
     * This method allows for StudyAreaCommand to print StudyArea based on its actual format,
     * so that formatMessage method does not interfere with the initial format.
     *
     * @param studyArea This is the StudyArea to be printed.
     */
    public void printStudyArea(StudyArea studyArea) {
        this.out.println(studyArea.toString());
    }

    /**
     * Display welcome message.
     */
    public void printWelcomeMessage() {

        //@@author NizarMohd-reused
        //Reused logo from http://patorjk.com/software/taag/#p=display&f=Graffiti&t=TypeSomething with minor
        // modifications. The website above allows for generation of fonts in ascii format. Therefore, logo is
        // generated from the service provided by the website.
        String logo = "_______/\\\\\\\\\\_____________________________________________________/\\\\\\\\\\_____/\\\\\\__"
                + "__________________________________________/\\\\\\____________\n"
                + "______/\\\\\\///\\\\\\__________________________________________________\\/\\\\\\\\\\\\___\\/\\\\\\_"
                + "_________________________________________/\\\\\\\\\\\\\\_________\n"
                + "_____/\\\\\\/__\\///\\\\\\____________________/\\\\\\\\\\\\\\\\___________________\\/\\\\\\/\\\\\\_"
                + "_\\/\\\\\\___/\\\\\\__________________________________/\\\\\\\\\\\\\\\\\\_______\n"
                + "_____/\\\\\\______\\//\\\\\\___/\\\\/\\\\\\\\\\\\\\____/\\\\\\////\\\\\\___/\\\\\\\\\\\\\\\\\\___"
                + "__\\/\\\\\\//\\\\\\_\\/\\\\\\__\\///_______/\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\__"
                + "_\\//\\\\\\\\\\\\\\_______\n"
                + "_____\\/\\\\\\_______\\/\\\\\\__\\/\\\\\\/////\\\\\\__\\//\\\\\\\\\\\\\\\\\\__\\////////\\\\\\___"
                + "_\\/\\\\\\\\//\\\\\\\\/\\\\\\___/\\\\\\____/\\\\\\//////_____/\\\\\\/////\\\\\\___\\//\\\\\\\\\\____"
                + "___\n"
                + "______\\//\\\\\\______/\\\\\\___\\/\\\\\\___\\///____\\///////\\\\\\____/\\\\\\\\\\\\\\\\\\\\__"
                + "_\\/\\\\\\_\\//\\\\\\/\\\\\\__\\/\\\\\\___/\\\\\\___________/\\\\\\\\\\\\\\\\\\\\\\_____\\//\\\\\\__"
                + "_____\n"
                + "________\\///\\\\\\__/\\\\\\_____\\/\\\\\\___________/\\\\_____\\\\\\___/\\\\\\/////\\\\\\__"
                + "_\\/\\\\\\__\\//\\\\\\\\\\\\__\\/\\\\\\__\\//\\\\\\_________\\//\\\\///////_______\\///_______\n"
                + "____________\\///\\\\\\\\\\/______\\/\\\\\\__________\\//\\\\\\\\\\\\\\\\__"
                + "_\\//\\\\\\\\\\\\\\\\/\\\\"
                + "_\\/\\\\\\___\\//\\\\\\\\\\__\\/\\\\\\___\\///\\\\\\\\\\\\\\\\___\\//\\\\\\\\\\\\\\\\\\\\_____"
                + "_/\\\\\\_____\n"
                + "______________\\/////________\\///____________\\////////_____\\////////\\//___\\///_____\\/////__"
                +  "_\\///______\\////////_____\\//////////______\\///_____";
        //@@author
        this.out.println("Hello from\n" + logo);
        this.out.println("What is your name?");
        printLine();
        String name = this.in.nextLine();
        printLine();
        this.out.println(TAB + "Hello " + name + "!");
        printMessage(START_MESSAGE);
        printLine();
    }

    /**
     * Prints an empty line.
     */
    public void printEmptyLine() {
        System.out.println();
    }

    /**
     * Display the list of supported commands.
     */
    public void printHelp() {
        printLine();
        this.out.println(TAB + "OrgaNice! Supports the following commands");
        this.out.println(TAB + "Please enter the keywords followed by the information shown in the brackets");
        this.out.println(TAB + "add <event details> /d <date> /s <start time> /e <end time> /p <priority "
                + "of event>");
        this.out.println(TAB + "------------------------------------------- Create a new event");
        this.out.println(TAB + "view -------------------------------------- View existing events");
        this.out.println(TAB + "priority_view ----------------------------- View existing events based "
                + "on priority");
        this.out.println(TAB + "countdown --------------------------------- View existing events based on"
                + " days left");
        this.out.println(TAB + "clear ------------------------------------- Delete all events");
        this.out.println(TAB + "search <keyword found in event> ----------- View existing events that contains "
                + "the keyword");
        this.out.println(TAB + "delete <index number of event> ------------ Delete the event");
        this.out.println(TAB + "help -------------------------------------- View List Of Commands Supported");
        this.out.println(TAB + "bye --------------------------------------- Terminate program");
        this.out.println(TAB + "Notes:");
        this.out.println(TAB + "*All dates should follow YYYY-MM-DD format");
        this.out.println(TAB + "*All timing should follow 24 hour clock");
        this.out.println(TAB + "*There are 4 levels of priority, with 1 being the most urgent, and 4 being the "
                + "least urgent");
        printLine();
    }

    /**
     * This is a modification of a code from Stack Overflow to format strings into a standard length. Minor edition is
     * made to ensure suitability with the program.
     * This method ensures that the message printed is within the standard<br>
     * length.
     * @param message is the String that we intend to format to a standard length<br>
     *                per line.<br>
     * @param maxLength This is the standard length intended to be formatted.
     * @return String of standard length per line
     */
    //@@author NizarMohd-reused
    //Reused from https://stackoverflow.com/questions/7528045/large-string-split-into-lines-with-maximum-length-in-java
    // with minor modification.
    public static String formatMessage(String message, int maxLength) {
        StringTokenizer token = new StringTokenizer(message, SPACE);
        StringBuilder standardLengthMessage = new StringBuilder(message.length());
        int lineLength = 0;
        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            if (lineLength + word.length() > maxLength) {
                String temp = standardLengthMessage.toString().trim();
                standardLengthMessage = new StringBuilder(temp);
                standardLengthMessage.append(lineSeparator() + "\t ");
                lineLength = 0;
            }
            standardLengthMessage.append(word).append(SPACE);
            lineLength += word.length() + 1;
        }
        return TAB + standardLengthMessage.toString().stripTrailing();
    }
    //@@author

}
