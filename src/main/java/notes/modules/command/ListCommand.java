package notes.modules.command;


import java.util.ArrayList;

//@@author terrytay
public class ListCommand implements Command {
    private ArrayList<String> messages;

    public ListCommand(ArrayList<String> messages) {
        this.messages = messages;
    }

    /**
     * Displays the notes in the module.
     */
    public void execute() {
        System.out.println("______________________________");
        if (messages.isEmpty()) {
            System.out.println("No notes have been added for this module yet.");
        }
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println("______________________________");
    }

    public void undo() {

    }

    public void redo() {

    }
}
