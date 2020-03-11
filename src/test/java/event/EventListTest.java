package event;

import org.junit.jupiter.api.Test;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Contains all the test related to EventList class.
 */
class EventListTest {

    Ui ui = new Ui();
    EventList eventList;

    public EventListTest() throws Exception {
        eventList = new EventList();
        eventList.addEvent(new Event("Team Meeting", "2020-03-21", "09:00",
                "17:00", "1"),ui);
    }

    @Test
    void deleteEvent_invalidIndex_throwException() {
        try {
            eventList.deleteEvent(2,ui);
        } catch (Exception e) {
            assertEquals("Invalid index entered. Please enter a valid index to be deleted",
                    e.getMessage());
        }
    }

    @Test
    void searchEvents_emptySearchKeyword_throwException() {
        try {
            eventList.searchEvents("",ui);
            fail("Empty string search not identified");
        } catch (Exception exception) {
            assertEquals("Keyword is empty", exception.getMessage());
        }
    }

    @Test
    void clearCommand() {
        eventList.clearEvents(ui);
        assertEquals(0, eventList.getEventListSize());
    }

}
