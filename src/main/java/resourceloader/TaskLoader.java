package resourceloader;

import task.Deadline;
import task.Event;
import task.Task;
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

import static ui.Constants.FILE_PATH_DICTIONARY;
import static ui.Constants.FILE_PATH_STUDYAREAS;

//@@author GanapathySanathBalaji
/**
 * Handles the task of loading and storing events.
 */
public class TaskLoader {

    public static final String INVALID_TASK_TYPE_MESSAGE = "Invalid task type identified when parsing tasks from "
            + "taskList.txt";

    /** Location of data file. */
    private String filePath;
    /** Directory of data file. */
    private Path fileDirectory;

    /**
     * Constructor for TaskLoader object.
     * Initialises the object with the file path provided.
     *
     * @param filePath The location of the data file.
     */
    public TaskLoader(String filePath) {
        this.filePath = filePath;
        this.fileDirectory = Paths.get(filePath).getParent();
    }


    /**
     * Reads the list of events stored previously and returns it as an ArrayList of Events.
     *
     * @return events The list of events stored previously.
     */
    public ArrayList<Task> loadFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        File dataFile;
        Scanner s;
        Ui ui = new Ui();
        try {
            dataFile = new File(filePath);
            s = new Scanner(dataFile);
            while (s.hasNext()) {
                String details = s.nextLine();
                Task newTask = parseTaskDetails(details);
                tasks.add(newTask);
            }
        }  catch (FileNotFoundException e) {
            createNewDataFile();
        } catch (Exception e) {
            ui.printLine();
            ui.printMessage(e.getMessage());
            ui.printLine();
        }
        return tasks;
    }

    /**
     * Parses the Task details from the given string and returns a new task object with the specified details.
     *
     * @param details Contains all the details with regards to the task.
     * @return newTask The new task created with the details provided.
     */
    private Task parseTaskDetails(String details) throws Exception {
        Task newTask = null;
        char taskType = details.charAt(0);
        String taskDetails = details.substring(2);
        switch (taskType) {
        case 'D':
            newTask = parseDeadlineDetails(taskDetails);
            break;
        case 'E':
            newTask = parseEventDetails(taskDetails);
            break;
        default:
            // Error handling
            assert false : INVALID_TASK_TYPE_MESSAGE;
            break;
        }
        return newTask;
    }



    /**
     * Parses the Deadline details from the given string and returns a new deadline object with the specified details.
     *
     * @param taskDescription Contains all the details with regards to the deadline.
     * @return newEvent The new event created with the details provided.
     */
    private Deadline parseDeadlineDetails(String taskDescription) throws Exception {
        String[] details = taskDescription.split("#", 6);
        String description = details[0];
        String date = details[1];
        String dueTime = details[2];
        String priority = details[3];
        boolean isDone = Boolean.parseBoolean(details[4]);
        Deadline newDeadline = new Deadline(description, date, dueTime, priority, isDone);
        return newDeadline;
    }


    /**
     * Parses the Event details from the given string and returns a new event object with the specified details.
     *
     * @param taskDescription Contains all the details with regards to the Event.
     * @return newEvent The new event created with the details provided.
     */
    private Event parseEventDetails(String taskDescription) throws Exception {
        String[] details = taskDescription.split("#", 5);
        String description = details[0];
        String date = details[1];
        String startTime = details[2];
        String endTime = details[3];
        String priority = details[4];
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
            File file = new File(String.valueOf(Paths.get(filePath)));
            final boolean b = file.setWritable(true);
            StudyAreaLoader.createNewStudyAreaData(FILE_PATH_STUDYAREAS);
            StudyAreaLoader.createNewStudyAreaData(FILE_PATH_DICTIONARY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the list of current tasks to the data file.
     *
     * @param tasks Represents the current list of events.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task task: tasks) {
                fw.write(task.getFormattedDetails());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}