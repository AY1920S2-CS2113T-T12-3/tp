package resourceloader;

import event.Event;
import ui.Ui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Handles the task of loading and storing events.
 */
public class EventLoader {

    /** Location of data file. */
    private String filePath;
    /** Directory of data file. */
    private Path fileDirectory;

    /**
     * Constructor for EventLoader object.
     * Initialises the object with the file path provided.
     *
     * @param filePath The location of the data file.
     */
    public EventLoader(String filePath) {
        this.filePath = filePath;
        this.fileDirectory = Paths.get(filePath).getParent();
    }


    /**
     * Reads the list of events stored previously and returns it as an ArrayList of Events.
     *
     * @return events The list of events stored previously.
     */
    public ArrayList<Event> loadFile() {
        ArrayList<Event> events = new ArrayList<>();;
        File dataFile;
        Scanner s;
        Ui ui = new Ui();
        try {
            dataFile = new File(filePath);
            s = new Scanner(dataFile);
            while (s.hasNext()) {
                String eventDescription = s.nextLine();
                Event newEvent = parseEventDetails(eventDescription);
                events.add(newEvent);
            }
        }  catch (FileNotFoundException e) {
            createNewDataFile();
        } catch (Exception e) {
            ui.printLine();
            ui.printMessage(e.getMessage());
            ui.printLine();
        }
        return events;
    }

    /**
     * Parses the Event details from the given string and returns a new event object with the specified details.
     *
     * @param taskDescription Contains all the details with regards to the Event.
     * @return newEvent The new event created with the details provided.
     */
    private Event parseEventDetails(String taskDescription) throws Exception {
        String[] splitDescription = taskDescription.split("#", 5);
        String description = splitDescription[0];
        String date = splitDescription[1];
        String startTime = splitDescription[2];
        String endTime = splitDescription[3];
        String priority = splitDescription[4];
        Event newEvent = new Event(description, date, startTime, endTime, priority);
        return newEvent;
    }


    /**
     * Creates a new data file when the application is run for the first time.
     */
    private void createNewDataFile() {
        try {
            Files.createDirectories(fileDirectory);
            Files.createFile(Paths.get(filePath));
            Files.createFile(Paths.get(Ui.FILE_PATH_STUDYAREAS));
            Files.createFile(Paths.get(Ui.FILE_PATH_DICTIONARY));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the list of current tasks to the data file.
     *
     * @param events Represents the current list of events.
     */
    public void saveEvents(ArrayList<Event> events) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Event event: events) {
                fw.write(event.getFormattedDetails());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}