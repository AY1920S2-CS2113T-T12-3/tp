package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

//@@author GanapathySanathBalaji

/**
 * Contains all the tests related to the Deadline class.
 */
class DeadlineTest {

    @Test
    void deadlineInformation() throws Exception {
        assertEquals("[D][PENDING] Assignment is due on Mar 21 2021 at 09:00 with priority 1",
                new Deadline("Assignment", "2021-03-21", "09:00",
                        "1", false).getTaskInformation());
    }

    @Test
    void formattedDetails() throws Exception {
        assertEquals("D#Assignment#2021-03-21#09:00#1#false" + System.lineSeparator(),
                new Deadline("Assignment", "2021-03-21", "09:00",
                        "1", false).getFormattedDetails());
    }

    @Test
    void createDeadline_invalidDate_throwException() {
        try {
            Deadline deadline = new Deadline("Assignment", "2021-03-021", "09:00",
                    "1", false);
            fail("Invalid date not rejected");
        } catch (Exception e) {
            assertEquals("Date provided is invalid or is in wrong format (Should be YYYY-MM-DD)",
                    e.getMessage());
        }
    }


    @Test
    void createDeadline_invalidDueTime_throwException() {
        try {
            Deadline deadline = new Deadline("Assignment", "2021-03-21", "25:00",
                    "1", false);
            fail("Invalid due time not rejected");
        } catch (Exception e) {
            assertEquals("Due time provided is invalid or in wrong format (Should be HH:MM) 24 Hr format",
                    e.getMessage());
        }
    }

    @Test
    void createDeadline_invalidPriority_throwException() {
        try {
            Deadline deadline = new Deadline("Assignment", "2021-03-21", "12:00",
                    "High", false);
            fail("Invalid priority not rejected");
        } catch (Exception e) {
            assertEquals("Priority should be an integer",e.getMessage());
        }
    }

    @Test
    void createDeadline_dateAlreadyPassed_throwException() {
        try {
            Deadline deadline = new Deadline("Assignment", "2020-03-21", "12:00",
                    "1", false);
            fail("Deadline before current date not rejected");
        } catch (Exception e) {
            assertEquals("Date specified must be a current or a future date",e.getMessage());
        }
    }

    @Test
    void searchKeyword_emptyKeyword_throwException() throws Exception {
        try {
            boolean hasKeyword = new Deadline("Assignment", "2021-03-21", "09:00",
                    "1", false).hasKeyword("");
            fail("Empty keyword not detected");
        } catch (Exception e) {
            assertEquals("Keyword to be used for search is empty", e.getMessage());
        }
    }

    @Test
    void searchKeyword_containsKeyword() throws Exception {
        assertTrue(new Deadline("Assignment", "2021-03-21", "09:00",
                "1", false).hasKeyword("Assignment"));
    }

    @Test
    void searchKeyword_doesntContainsKeyword() throws Exception {
        assertFalse(new Deadline("Assignment", "2021-03-21", "09:00",
                "1", false).hasKeyword("Project"));
    }

    @Test
    void calendarDetails() throws Exception {
        assertEquals("[D][N] Assignment        ",
                new Deadline("Assignment", "2021-03-21", "09:00",
                        "1", false).getCalendarTaskDetails());
    }

    @Test
    void calendarDetails_longDescription() throws Exception {
        assertEquals("[D][Y] Project proposa...",
                new Deadline("Project proposal submission", "2021-03-21", "09:00",
                        "1", true).getCalendarTaskDetails());
    }
}
