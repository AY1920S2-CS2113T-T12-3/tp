package command;

import studyarea.IllegalStudyAreaException;
import studyarea.StudyArea;
import studyarea.StudyAreaList;
import ui.Ui;
import java.util.ArrayList;
import static ui.Constants.AVAILABLE_STUDY_AREAS;
import static ui.Constants.BYE_COMMAND;
import static ui.Constants.EMPTY_LIST;
import static ui.Constants.EMPTY_LOCATION;
import static ui.Constants.END_MESSAGE;
import static ui.Constants.FLAGS;
import static ui.Constants.HELP_COMMAND;
import static ui.Constants.PROMPT_USER;
import static ui.Constants.START_STUDY_AREA_SEARCH;


/**
 * This is the StudyAreaCommand class. It executes the StudyArea Search function and interact with Users accordingly.
 */

public class StudyAreaCommand {

    /**
     * List out all the StudyAreas that match with User's preference.
     * @param ui This allows for StudyAreaCommand to interact with Users.
     * @param availStudyAreas this is the list of all study areas in location.txt.
     */
    public static void printList(ArrayList<StudyArea> availStudyAreas, Ui ui) {
        if (availStudyAreas.isEmpty()) {
            ui.printMessage(EMPTY_LIST);
        } else {
            ui.printMessage(AVAILABLE_STUDY_AREAS);
            for (StudyArea studyArea : availStudyAreas) {
                ui.printStudyArea(studyArea);
            }
        }
    }


    /**
     * Filters command based on User Input.
     * @param command This is the command entered by User.
     * @param studyAreaList This is the list of all StudyAreas in location.txt.
     * @param ui This allows for StudyAreaCommand to interact with Users.
     * @return boolean status. False if User enters "end" , else will always return true;
     * @throws IllegalStudyAreaException if User enters invalid commands.
     */

    public static boolean filterCommand(String command, StudyAreaList studyAreaList, Ui ui) throws
            IllegalStudyAreaException {

        command = command.trim();
        if (command.isBlank()) {
            throw new IllegalStudyAreaException(EMPTY_LOCATION);
        } else {
            switch (command) {
            case BYE_COMMAND:
                ui.printMessage(END_MESSAGE);
                return false;
            case HELP_COMMAND:
                ui.printMessage(FLAGS);
                break;
            default:
                try {
                    ArrayList<StudyArea> availStudyAreas = studyAreaList.searchList(command);
                    printList(availStudyAreas, ui);
                    ui.printMessage(PROMPT_USER);
                } catch (IllegalStudyAreaException e) {
                    ui.printMessage(e.getMessage());
                }
                break;
            }
        }
        return true;
    }
    
    /**
     * Executes the StudyArea search feature.
     * @param ui This allows for StudyAreaCommand to interact with Users.
     * @param studyAreaList studyAreaList object that holds information on studyAreas available.
     */
    public static void runCommands(StudyAreaList studyAreaList, Ui ui)  {
        ui.printLine();
        ui.printMessage(START_STUDY_AREA_SEARCH);
        boolean status = true;
        while (status) {
            ui.printLine();
            String command = ui.getUserIn().toLowerCase();
            ui.printLine();
            try {
                status = filterCommand(command, studyAreaList, ui);
            } catch (IllegalStudyAreaException e) {
                ui.printMessage(e.getMessage());
            }
        }
        ui.printLine();
    }
}