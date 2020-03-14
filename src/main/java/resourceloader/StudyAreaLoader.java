package resourceloader;

import studyarea.Dictionary;
import studyarea.IllegalStudyAreaException;
import studyarea.StudyArea;
import ui.Ui;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class loads all the required information of Study Areas that is stored in location.txt.
 */

public class StudyAreaLoader {
    private static final String DIVIDER = "~";
    private String url;
    private File file;

    public StudyAreaLoader(String url) throws IllegalStudyAreaException {
        this.url = url;
        loadFile();
    }

    /**
     * Loads content from location.txt and dictionary.txt.
     * @throws IllegalStudyAreaException if file is not found.
     */
    public void loadFile() throws IllegalStudyAreaException {
        try {
            this.file = new File(this.url);
            Dictionary.loadDictionary();
        }  catch (NullPointerException e) {
            throw new IllegalStudyAreaException(Ui.MISSING_STUDY_AREA_DATA);
        } catch (FileNotFoundException e) {
            throw new IllegalStudyAreaException(e.getMessage());
        }
    }

    /**
     * Return the imported study area file as an ArrayList for the main controller
     * to add it to its database.
     *
     * @return buffer ArrayList of Location from study area file
     * @throws FileNotFoundException if location.txt does not exist.
     * @throws IllegalStudyAreaException if data stored is inconsistent
     */

    public ArrayList<StudyArea> pushToDatabase() throws IllegalStudyAreaException, FileNotFoundException {
        ArrayList<StudyArea> buffer = new ArrayList<>();
        Scanner input = new Scanner(this.file);
        while (input.hasNextLine()) {
            String detailsOfLocation = input.nextLine();
            String[] detailsBuffer = detailsOfLocation.split(DIVIDER);
            if (detailsBuffer.length != 6) {
                String name = detailsBuffer[0];
                throw new IllegalStudyAreaException(Ui.INCONSISTENT_DATA_STORAGE + "at " + name);
            }
            StudyArea studyArea = new StudyArea(detailsBuffer[0], detailsBuffer[1], detailsBuffer[2],
                    Boolean.parseBoolean(detailsBuffer[3]), Boolean.parseBoolean(detailsBuffer[4]),
                    Integer.parseInt(detailsBuffer[5]));
            buffer.add(studyArea);
        }
        input.close();
        return buffer;
    }
}

