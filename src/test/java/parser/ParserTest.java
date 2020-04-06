package parser;

import command.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//@@author GanapathySanathBalaji
/**
 * Contains all test regarding the Parser Class.
 */
class ParserTest {

    Parser parser = new Parser();
    Command command;

    @Test
    void parseCommand_emptyAddEventCommand_throwException() {
        try {
            command = parser.parseCommand("event");
            fail("Empty add command not identified");
        } catch (Exception exception) {
            assertEquals("Event details are not provided",exception.getMessage());
        }
    }

    @Test
    void parseCommand_emptyAddDeadlineCommand_throwException() {
        try {
            command = parser.parseCommand("event");
            fail("Empty add command not identified");
        } catch (Exception exception) {
            assertEquals("Event details are not provided",exception.getMessage());
        }
    }

    @Test
    void parseCommand_emptyCommand_throwException() {
        try {
            command = parser.parseCommand("");
            fail("Empty command not identified");
        } catch (Exception exception) {
            assertEquals("Empty Line entered, Please enter a valid line",exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidCommand_throwException() {
        try {
            command = parser.parseCommand("list");
            fail("Invalid command not identified");
        } catch (Exception exception) {
            assertEquals("Invalid command entered, Please enter a valid command",exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidPriorityViewCommand_throwException() {
        try {
            command = parser.parseCommand("priority_view of events");
            fail("Invalid priority view command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view events sorted by priority (Should be :priority_view )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidCountdownViewCommand_throwException() {
        try {
            command = parser.parseCommand("countdown of events");
            fail("Invalid countdown view command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view countdown of events (Should be :countdown )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidViewCommand_throwException() {
        try {
            command = parser.parseCommand("view events");
            fail("Invalid view command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view events (Should be :view )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidClearCommand_throwException() {
        try {
            command = parser.parseCommand("clear events");
            fail("Invalid clear command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command to clear events (Should be :clear )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidHelpCommand_throwException() {
        try {
            command = parser.parseCommand("help for commands");
            fail("Invalid help command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view command list (Should be :help )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_emptySearchCommand_throwException() {
        try {
            command = parser.parseCommand("search ");
            fail("Empty search command not identified");
        } catch (Exception exception) {
            assertEquals("The search string entered is empty.",exception.getMessage());
        }
    }

    @Test
    void parseCommand_emptyDeleteCommand_throwException() {
        try {
            command = parser.parseCommand("delete ");
            fail("Empty delete command not identified");
        } catch (Exception exception) {
            assertEquals("Index to delete not mentioned", exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidDeleteCommand_throwException() {
        try {
            command = parser.parseCommand("delete one");
            fail("Invalid delete command not identified");
        } catch (Exception exception) {
            assertEquals("Enter a valid integer index (1-based) to delete/edit/done the corresponding event "
                            + "(format: delete/edit/done index)",
                    exception.getMessage());
        }
    }

}
