package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//@@author GanapathySanathBalaji
/**
 * Contains all the tests related to the Event class.
 */
class EventTest {

    @Test
    void eventInformation() throws Exception {
        assertEquals("[E] Team Meeting at Mar 21 2021 from 09:00 to 17:00 with priority 1",
                new Event("Team Meeting", "2021-03-21", "09:00",
                        "17:00", "1").getTaskInformation());
    }

    @Test
    void formattedDetails() throws Exception {
        assertEquals("E#Team Meeting#2021-03-21#09:00#17:00#1" + System.lineSeparator(),
                new Event("Team Meeting", "2021-03-21", "09:00",
                        "17:00", "1").getFormattedDetails());
    }

    @Test
    void createEvent_invalidDate_throwException() {
        try {
            Event event = new Event("Team Meeting", "2020-03-021", "09:00",
                    "17:00", "1");
            fail("Invalid date not rejected");
        } catch (Exception e) {
            assertEquals("Date provided is invalid or is in wrong format (Should be YYYY-MM-DD)",
                    e.getMessage());
        }
    }


    @Test
    void createEvent_invalidStartTime_throwException() {
        try {
            Event event = new Event("Team Meeting", "2021-03-21", "25:00",
                    "17:00", "1");
            fail("Invalid start time not rejected");
        } catch (Exception e) {
            assertEquals("Start time provided is invalid or in wrong format (Should be HH:MM) 24 Hr format",
                    e.getMessage());
        }
    }

    @Test
    void createEvent_invalidEndTime_throwException() {
        try {
            Event event = new Event("Team Meeting", "2021-03-21", "09:00",
                    "10:70", "1");
            fail("Invalid end time not rejected");
        } catch (Exception e) {
            assertEquals("End time provided is invalid or in wrong format (Should be HH:MM) 24 Hr format",
                    e.getMessage());
        }
    }

    @Test
    void createEvent_invalidPriority_throwException() {
        try {
            Event event = new Event("Team Meeting", "2021-03-21", "09:00",
                    "10:50", "High");
            fail("Invalid priority not rejected");
        } catch (Exception e) {
            assertEquals("Priority should be an integer",e.getMessage());
        }
    }

    @Test
    void createEvent_startTimeAfterEndTime_throwException() {
        try {
            Event event = new Event("Team Meeting", "2021-03-21", "09:00",
                    "08:50", "1");
            fail("Start time after end time not rejected");
        } catch (Exception e) {
            assertEquals("Start time should be before End time",e.getMessage());
        }
    }

    @Test
    void createEvent_dateAlreadyPassed_throwException() {
        try {
            Event event = new Event("Team Meeting", "2019-03-21", "09:00",
                    "09:50", "1");
            fail("Event before current date not rejected");
        } catch (Exception e) {
            assertEquals("Date specified must be a current or a future date",e.getMessage());
        }
    }

    @Test
    void searchKeyword_emptyKeyword_throwException() throws Exception {
        try {
            boolean hasKeyword = new Event("Team Meeting", "2021-03-21", "09:00",
                    "17:00", "1").hasKeyword("");
            fail("Empty keyword not detected");
        } catch (Exception e) {
            assertEquals("Keyword to be used for search is empty", e.getMessage());
        }
    }

    @Test
    void searchKeyword_containsKeyword() throws Exception {
        assertEquals(true, new Event("Team Meeting", "2021-03-21", "09:00",
                "17:00", "1").hasKeyword("Meeting"));
    }

    @Test
    void searchKeyword_doesntContainsKeyword() throws Exception {
        assertEquals(false, new Event("Team Meeting", "2021-03-21", "09:00",
                "17:00", "1").hasKeyword("Class"));
    }

    @Test
    void calendarDetails() throws Exception {
        assertEquals("[E] Team Meeting         ",
                new Event("Team Meeting", "2021-03-21", "09:00",
                        "17:00", "1").getCalendarTaskDetails());
    }

    @Test
    void calendarDetails_longDescription() throws Exception {
        assertEquals("[E] Programming worksh...",
                new Event("Programming workshop for high school students", "2021-03-21", "09:00",
                        "17:00", "1").getCalendarTaskDetails());
    }

}
