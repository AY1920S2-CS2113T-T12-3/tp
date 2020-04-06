package notes.modules.command;

//@@author terrytay
public interface Command {

    public void execute();

    public void undo();

    public void redo();
}
