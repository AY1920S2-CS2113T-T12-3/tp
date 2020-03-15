package ui;


import studyarea.StudyArea;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.System.lineSeparator;
import static ui.Constants.BYE_COMMAND;
import static ui.Constants.DAB;
import static ui.Constants.GOODBYE_MESSAGE;
import static ui.Constants.HELP_DESCRIPTION_1;
import static ui.Constants.HELP_DESCRIPTION_10;
import static ui.Constants.HELP_DESCRIPTION_11;
import static ui.Constants.HELP_DESCRIPTION_12;
import static ui.Constants.HELP_DESCRIPTION_13;
import static ui.Constants.HELP_DESCRIPTION_14;
import static ui.Constants.HELP_DESCRIPTION_15;
import static ui.Constants.HELP_DESCRIPTION_16;
import static ui.Constants.HELP_DESCRIPTION_17;
import static ui.Constants.HELP_DESCRIPTION_18;
import static ui.Constants.HELP_DESCRIPTION_19;
import static ui.Constants.HELP_DESCRIPTION_2;
import static ui.Constants.HELP_DESCRIPTION_20;
import static ui.Constants.HELP_DESCRIPTION_3;
import static ui.Constants.HELP_DESCRIPTION_4;
import static ui.Constants.HELP_DESCRIPTION_5;
import static ui.Constants.HELP_DESCRIPTION_7;
import static ui.Constants.HELP_DESCRIPTION_8;
import static ui.Constants.HELP_DESCRIPTION_9;
import static ui.Constants.LINE;
import static ui.Constants.MAX_LINE_LENGTH;
import static ui.Constants.SPACE;
import static ui.Constants.START_MESSAGE;
import static ui.Constants.STUDY_COMMAND;
import static ui.Constants.TAB;
import static ui.Constants.TASK_COMMAND;

/**
 * Contains functions used to interact with the user.
 *
 */
public class Ui {
    private final Scanner in;
    private final PrintStream out;

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
        case TASK_COMMAND :
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
        this.out.println(HELP_DESCRIPTION_1);
        this.out.println(HELP_DESCRIPTION_2);
        this.out.println(HELP_DESCRIPTION_3);
        this.out.println(HELP_DESCRIPTION_4);
        this.out.println(HELP_DESCRIPTION_5);
        this.out.println(HELP_DESCRIPTION_7);
        this.out.println(HELP_DESCRIPTION_8);
        this.out.println(HELP_DESCRIPTION_9);
        this.out.println(HELP_DESCRIPTION_10);
        this.out.println(HELP_DESCRIPTION_11);
        this.out.println(HELP_DESCRIPTION_12);
        this.out.println(HELP_DESCRIPTION_13);
        this.out.println(HELP_DESCRIPTION_14);
        this.out.println(HELP_DESCRIPTION_15);
        this.out.println(HELP_DESCRIPTION_16);
        this.out.println(HELP_DESCRIPTION_17);
        this.out.println(HELP_DESCRIPTION_18);
        this.out.println(HELP_DESCRIPTION_19);
        this.out.println(HELP_DESCRIPTION_20);
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
                standardLengthMessage.append(lineSeparator()).append("\t ");
                lineLength = 0;
            }
            standardLengthMessage.append(word).append(SPACE);
            lineLength += word.length() + 1;
        }
        return TAB + standardLengthMessage.toString().stripTrailing();
    }
    //@@author

}
