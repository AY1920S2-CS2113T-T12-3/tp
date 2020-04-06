package notes;

import exception.NotesCommandException;
import ui.Constants;

import java.io.IOException;
import java.util.Scanner;


//@@author terrytay
public class NotesInvoker {

    /**
     * Constructor to invoke Notes app.
     * @throws IOException exception for module import/export
     */
    public NotesInvoker() throws Exception {
        Notes notes = new Notes();
        System.out.println(Constants.NOTES_WELCOME_MESSAGE);
        System.out.println(Constants.LINE_BREAK);
        displayMenu();

        Scanner input = new Scanner(System.in);
        String choice;
        try {
            do {
                String userInput = input.nextLine();
                choice = userInput.split(" ")[0];
                String code;
                switch (choice) {
                case "add":
                    code = userInput.split(" ")[1];
                    notes.createModule(code);
                    break;
                case "remove":
                    code = userInput.split(" ")[1];
                    notes.deleteModule(code);
                    break;
                case "enter":
                    code = userInput.split(" ")[1];
                    notes.enterModule(code);
                    break;
                case "list":
                    notes.listModules();
                    break;
                case "exit":
                    notes.exportModules();
                    break;
                case "help":
                    displayMenu();
                    break;
                default:
                    System.out.println(Constants.INVALID_NOTES_COMMAND_MESSAGE);
                }

            } while (!choice.equals("exit"));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NotesCommandException();
        }
        System.out.println("Thank you for using notes.");
    }

    private void displayMenu() {
        System.out.println(Constants.ADD_MODULE_MESSAGE);
        System.out.println(Constants.REMOVE_MODULE_MESSAGE);
        System.out.println(Constants.ENTER_MODULE_MESSAGE);
        System.out.println(Constants.LIST_MODULE_MESSAGE);
        System.out.println(Constants.EXIT_MODULE_MESSAGE);
        System.out.println(Constants.HELP_MODULE_MESSAGE);
    }
}
