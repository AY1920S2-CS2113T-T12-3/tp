package command;

import studyarea.IllegalStudyAreaException;
import studyarea.StudyArea;
import studyarea.StudyAreaList;
import ui.Ui;

import java.util.ArrayList;


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
            ui.printMessage(Ui.EMPTY_LIST);
        } else {
            ui.printMessage(Ui.AVAILABLE_STUDY_AREAS);
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
            throw new IllegalStudyAreaException(Ui.EMPTY_LOCATION);
        } else {
            switch (command) {
            case Ui.BYE_COMMAND:
                ui.printMessage(Ui.END_MESSAGE);
                return false;
            case Ui.HELP_COMMAND:
                ui.printMessage(Ui.FLAGS);
                break;
            default:
                try {
                    ArrayList<StudyArea> availStudyAreas = studyAreaList.searchList(command);
                    printList(availStudyAreas, ui);
                    ui.printMessage(Ui.PROMPT_USER);
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
        ui.printMessage(Ui.START_STUDY_AREA_SEARCH);
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