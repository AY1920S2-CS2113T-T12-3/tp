package parser;

import command.Command;
import org.junit.jupiter.api.Test;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains all test regarding the Parser Class.
 */
class ParserTest {

    Ui ui = new Ui();
    Parser parser = new Parser();
    Command command;

    @Test
    void parseCommand_emptyAddCommand_throwException() {
        try {
            command = parser.parseCommand("add",ui);
            fail("Empty add command not identified");
        } catch (Exception exception) {
            assertEquals("Event details isn't provided",exception.getMessage());
        }
    }


    @Test
    void parseCommand_emptyCommand_throwException() {
        try {
            command = parser.parseCommand("",ui);
            fail("Empty command not identified");
        } catch (Exception exception) {
            assertEquals("Empty Line entered, Please enter a valid line",exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidCommand_throwException() {
        try {
            command = parser.parseCommand("list",ui);
            fail("Invalid command not identified");
        } catch (Exception exception) {
            assertEquals("Invalid command entered, Please enter a valid command",exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidPriorityViewCommand_throwException() {
        try {
            command = parser.parseCommand("priority_view of events", ui);
            fail("Invalid priority view command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view events sorted by priority (Should be :priority_view )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidCountdownViewCommand_throwException() {
        try {
            command = parser.parseCommand("countdown of events", ui);
            fail("Invalid countdown view command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view countdown of events (Should be :countdown )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidViewCommand_throwException() {
        try {
            command = parser.parseCommand("view events", ui);
            fail("Invalid view command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view events (Should be :view )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidClearCommand_throwException() {
        try {
            command = parser.parseCommand("clear events", ui);
            fail("Invalid clear command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command clear events (Should be :clear )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidHelpCommand_throwException() {
        try {
            command = parser.parseCommand("help for commands", ui);
            fail("Invalid help command not identified");
        } catch (Exception exception) {
            assertEquals("Wrong command used to view command list (Should be :help )",
                    exception.getMessage());
        }
    }

    @Test
    void parseCommand_emptySearchCommand_throwException() {
        try {
            command = parser.parseCommand("search ", ui);
            fail("Empty search command not identified");
        } catch (Exception exception) {
            assertEquals("The search string entered is empty.",exception.getMessage());
        }
    }

    @Test
    void parseCommand_emptyDeleteCommand_throwException() {
        try {
            command = parser.parseCommand("delete ", ui);
            fail("Empty delete command not identified");
        } catch (Exception exception) {
            assertEquals("Index to delete not mentioned", exception.getMessage());
        }
    }

    @Test
    void parseCommand_invalidDeleteCommand_throwException() {
        try {
            command = parser.parseCommand("delete one", ui);
            fail("Invalid delete command not identified");
        } catch (Exception exception) {
            assertEquals("Enter a valid integer index (1-based) to delete the corresponding event "
                            + "(format: delete index)",
                    exception.getMessage());
        }
    }

}