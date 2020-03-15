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
import static ui.Constants.DAB;
import static ui.Constants.GOODBYE_MESSAGE;
import static ui.Constants.INTERMEDIATE_MESSAGE;
import static ui.Constants.WRONG_INPUT;


/**
 * This is Duke class, which forms the main class of the program.
 */
public class Duke {

    public static final String FILE_PATH_EVENTS = "library" + File.separator + "taskList.txt";
    public static final String FILE_PATH_STUDYAREAS = "library" + File.separator + "locations.txt";
    private static TaskLoader taskLoader;
    protected static StudyAreaLoader studyAreaLoader;
    private static TaskList taskList = new TaskList();
    private static StudyAreaList studyAreaList;
    private static Ui ui = new Ui();
    private static Parser parser;

    /**
     * This is the constructor to create a new Duke program every time user runs the main loop.
     */
    public Duke()  {
        try {
            parser = new Parser();
            taskLoader = new TaskLoader(FILE_PATH_EVENTS);
            taskList = new TaskList(taskLoader.loadFile());
            studyAreaLoader = new StudyAreaLoader(FILE_PATH_STUDYAREAS);
            studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());
        } catch (FileNotFoundException | IllegalStudyAreaException e) {
            ui.printLine();
            ui.printMessage(e.getMessage());
            ui.printLine();
        }
    }

    /**
     * This method runs the program.
     */
    public void run() {
        ui.printWelcomeMessage();
        boolean status = true;
        while (status) {
            int mode = ui.getMode();
            switch (mode) {
            case -1:
                status = false;
                break;
            case 1:
                TaskCommand.runCommands(taskList, ui, parser);
                ui.printMessage(INTERMEDIATE_MESSAGE);
                break;
            case 2:
                StudyAreaCommand.runCommands(studyAreaList, ui);
                ui.printMessage(INTERMEDIATE_MESSAGE);
                break;
            default:
                ui.printLine();
                ui.printMessage(WRONG_INPUT);
                break;
            }
            ui.printLine();
        }
        taskLoader.saveTasks(taskList.tasks);
        ui.printMessage(GOODBYE_MESSAGE + DAB);
        ui.close();
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
