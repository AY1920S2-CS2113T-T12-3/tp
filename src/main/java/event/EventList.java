package event;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ui.Ui;

/**
 * Handles all functions related to the list of events.
 */
public class EventList {


    /** Stores the event information. */
    public ArrayList<Event> events;

    /**
     * Constructor for the EventList class.
     */
    public EventList() {
        events = new ArrayList<Event>();
    }

    /**
     * Overloaded constructor for EventList class.
     *
     * @param events The list of events the class's list of events is initialised with.
     */
    public EventList(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Returns the number of events currently stored.
     *
     * @return The number of events stored currently.
     */
    public int getEventListSize() {
        return events.size();
    }

    /**
     * Adds a new event to the list.
     *
     * @param ui This allows Event List class to interact with User.
     * @param newEvent Event represents the new event tot be added.
     */
    public void addEvent(Event newEvent, Ui ui) {
        events.add(newEvent);
        ui.printLine();
        ui.printMessage("A new event with the following information has been added.");
        ui.printMessage(newEvent.getEventInformation());
        ui.printLine();
    }

    /**
     * Displays the current list of events.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void listEvents(Ui ui) {
        ui.printLine();
        ui.printMessage("Here is the list of events added so far:");
        int eventNumber = 1;
        for (Event event: events) {
            ui.printMessage(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        ui.printLine();
    }

    /**
     * Deletes the event at the specified index.
     *
     * @param ui This allows Event List class to interact with User.
     * @param index The index (1-based) of the event to be deleted.
     * @throws Exception If the index specified is invalid.
     */
    public void deleteEvent(int index, Ui ui) {
        ui.printLine();
        try {
            if (index > events.size() | index <= 0) {
                throw new IndexOutOfBoundsException();
            }
            events.remove(index - 1);
            ui.printLine();
            ui.printMessage("The event at the mentioned index has been deleted");
            ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            ui.printMessage("Invalid index entered. Please enter a valid index to be deleted");
            ui.printLine();
        }

    }

    /**
     * Clears all the events currently stored.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void clearEvents(Ui ui) {
        events.clear();
        ui.printLine();
        ui.printMessage("The list of events is cleared.");
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by their priority.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void priorityView(Ui ui) {
        ArrayList<Event> eventsSortedByPriority = events;
        eventsSortedByPriority.sort(Comparator.comparingInt(Event::getPriority));
        Collections.reverse(eventsSortedByPriority);
        ui.printLine();
        int eventNumber = 1;
        for (Event event:eventsSortedByPriority) {
            ui.printMessage(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        if (eventNumber == 1) {
            ui.printMessage("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by date along with the days remaining.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void countdownView(Ui ui) {
        ArrayList<Event> eventsSortedByDate = events;
        eventsSortedByDate.sort(Comparator.comparing(Event::getDate));
        ui.printLine();
        int eventNumber = 1;
        for (Event event:eventsSortedByDate) {
            ui.printMessage(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        if (eventNumber == 1) {
            ui.printMessage("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Displays the list of events containing the keyword.
     *
     * @param ui This allows Event List class to interact with User.
     * @param keyword The keyword to be searched for.
     * @throws Exception If the keyword is empty.
     */
    public void searchEvents(String keyword, Ui ui) throws Exception {
        int eventNumber = 1;
        ui.printLine();
        for (Event event:events) {
            if (event.hasKeyword(keyword)) {
                ui.printMessage(eventNumber + ") " + event.getEventInformation());
                eventNumber++;
            }
        }
        if (eventNumber == 1) {
            ui.printMessage("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Adds a new event to the list by parsing information from the user given string
     * and calling {@link #addEvent(Event, Ui)} if the information is given in the correct format
     * to add the event.
     *
     * @param ui This allows Event List class to interact with User.
     * @param eventDetails Contains all the information related to the event as provided by the user.
     */
    public void add(String eventDetails, Ui ui) {
        try {
            String[] details = eventDetails.split(" ",2)[1].split("/");
            String description = details[0];
            String date = details[1].substring(2);
            String startTime = details[2].substring(2);
            String endTime = details[3].substring(2);
            String priority = details[4].substring(2);
            Event newEvent =  new Event(description,date,startTime,endTime,priority);
            addEvent(newEvent, ui);
        } catch (IndexOutOfBoundsException | DateTimeParseException | NullPointerException e) {
            ui.printLine();
            ui.printMessage("Wrong format to add events");
            ui.printLine();
        } catch (Exception e) {
            ui.printLine();
            ui.printMessage(e.getMessage());
            ui.printLine();
        }
    }



}