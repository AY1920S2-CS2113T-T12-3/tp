package seedu.duke;

import parser.Parser;
import command.TaskCommand;
import command.StudyAreaCommand;
import resourceloader.TaskLoader;
import resourceloader.StudyAreaLoader;
import studyarea.IllegalStudyAreaException;
import studyarea.StudyAreaList;
import task.TaskList;
import ui.Ui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static ui.Constants.DAB;
import static ui.Constants.GOODBYE_MESSAGE;
import static ui.Constants.INTERMEDIATE_MESSAGE;
import static ui.Constants.WRONG_INPUT;


/**
 * This is Duke class, which forms the main class of the program.
 */
public class Duke {

    public static final String FILE_PATH_EVENTS = "library" + File.separator + "taskList.txt";
    public static final String FILE_PATH_STUDY_AREAS = "library" + File.separator + "locations.txt";
    public static final String EXCEPTION_ENCOUNTERED_MESSAGE = "Exception encountered when Duke was constructed";
    public static final String DUKE_LOGGER_LOG = "dukeLogger.log";
    public static final String FILE_LOGGER_NOT_WORKING_MESSAGE = "File Logger not working";
    public static final String APPLICATION_STARTED_EXECUTION = "Application started Execution";
    public static final String APPLICATION_GOING_TO_EXIT = "Application is going to exit";
    public static final String TASK_MODE = "Application transitioning to task mode";
    public static final String STUDY_AREA_MODE = "Application transitioning to study area mode";
    public static final String WRONG_COMMAND = "Wrong command entered by user";
    public static final String APPLICATION_CLOSED_SUCCESSFULLY = "Application closed successfully";

    private static TaskLoader taskLoader;
    protected static StudyAreaLoader studyAreaLoader;
    private static TaskList taskList = new TaskList();
    private static StudyAreaList studyAreaList;
    private static Ui ui = new Ui();
    private static Parser parser;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * This is the constructor to create a new Duke program every time user runs the main loop.
     */
    public Duke()  {
        try {
            setupLogger();
            parser = new Parser();
            taskLoader = new TaskLoader(FILE_PATH_EVENTS);
            taskList = new TaskList(taskLoader.loadFile());
            studyAreaLoader = new StudyAreaLoader(FILE_PATH_STUDY_AREAS);
            studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());
        } catch (FileNotFoundException | IllegalStudyAreaException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_ENCOUNTERED_MESSAGE);
            studyAreaList = new StudyAreaList();
        }
    }

    private void setupLogger() {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        ch.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(ch);
        try {
            FileHandler fh = new FileHandler(DUKE_LOGGER_LOG);
            fh.setLevel(Level.INFO);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, FILE_LOGGER_NOT_WORKING_MESSAGE, e);
        }
    }

    /**
     * This method runs the program.
     */
    public void run() {
        LOGGER.log(Level.INFO, APPLICATION_STARTED_EXECUTION);
        ui.printWelcomeMessage();
        boolean status = true;
        while (status) {
            int mode = ui.getMode();
            switch (mode) {
            case -1:
                LOGGER.log(Level.INFO, APPLICATION_GOING_TO_EXIT);
                status = false;
                break;
            case 1:
                LOGGER.log(Level.INFO, TASK_MODE);
                TaskCommand.runCommands(taskList, ui, parser);
                ui.printMessage(INTERMEDIATE_MESSAGE);
                break;
            case 2:
                LOGGER.log(Level.INFO, STUDY_AREA_MODE);
                StudyAreaCommand.runCommands(studyAreaList, ui);
                ui.printMessage(INTERMEDIATE_MESSAGE);
                break;
            default:
                LOGGER.log(Level.INFO, WRONG_COMMAND);
                ui.printLine();
                ui.printMessage(WRONG_INPUT);
                break;
            }
            ui.printLine();
        }
        taskLoader.saveTasks(taskList.tasks);
        ui.printMessage(GOODBYE_MESSAGE + DAB);
        ui.close();
        LOGGER.log(Level.INFO, APPLICATION_CLOSED_SUCCESSFULLY);
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args this is an optional argument.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

}
