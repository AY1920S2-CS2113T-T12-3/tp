package notes.modules;

import notes.modules.command.AddCommand;
import notes.modules.command.Command;
import notes.modules.command.CommandStack;
import notes.modules.command.ExitCommand;
import notes.modules.parser.Parser;

import java.util.ArrayList;
import java.util.Scanner;

//@@author terrytay
public class ModuleManager {
    private String code;
    private ArrayList<String> messages;
    private CommandStack commandStack;

    /**
     * Manages the module e.g. overall commands and control.
     * @param code module code
     * @param messages the notes in the module
     * @throws Exception for commandStack
     */
    public ModuleManager(String code, ArrayList<String> messages) throws Exception {
        this.code = code;
        this.messages = messages;
        commandStack = new CommandStack();
        runInstance();
    }

    private void runInstance() throws Exception {
        System.out.println(String.format("Notes for %s", code));
        Command command;
        showMenu();
        do {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            command = new Parser().parseCommand(userInput, this);
            executeCommand(command);
        } while (!ExitCommand.isExit(command));

    }

    /**
     * Takes the command and execute. Depending on whether it's add,
     * redo or undo or others, it will run differently.
     * @param command the command to be executed
     */
    public void executeCommand(Command command) {
        if (command instanceof AddCommand) {
            switch (((AddCommand) command).getUserCommandType()) {
            case "add":
                commandStack.execute(command);
                break;
            case "undo":
                commandStack.undo();
                break;
            case "redo":
                commandStack.redo();
                break;
            default:
                break;
            }
        } else {
            command.execute();
        }

    }

    private void showMenu() {
        System.out.println("[add ...message...] to add a note");
        System.out.println("[undo] to undo");
        System.out.println("[redo] to redo");
        System.out.println("[list] to list notes");
        System.out.println("[exit] to exit");
    }

    public void addMessage(String message) {
        messages.add(message);
        System.out.println("SUCCESS");
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public void removeMessage(String message) {
        messages.remove(message);
        System.out.println("SUCCESS");
    }
}
