package notes.modules.command;

//@@author terrytay
public class ExitCommand implements Command {

    public void execute() {
    }

    public void undo() {

    }

    public void redo() {

    }

    /**
     * Implemented from https://github.com/se-edu/addressbook-level2/
     * blob/master/src/seedu/addressbook/commands/ExitCommand.java.
     * To check if command is exit command.
     * @param command the command parsed
     * @return true if command parsed is exit command
     */
    public static boolean isExit(Command command) {
        return command instanceof ExitCommand;
    }
}
