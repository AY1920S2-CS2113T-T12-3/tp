package notes;


import ui.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//@@author terrytay
public class Notes {
    ModulesList modulesList;

    public Notes() {
        modulesList = ModulesList.getInstance();
        importModules();
    }

    /**
     * Creates a module.
     *
     * @param code Module Code.
     */
    public void createModule(String code) {
        code = code.toUpperCase();

        modulesList.createModule(code);
    }

    /**
     * Deletes a module.
     *
     * @param code Module Code.
     */
    public void deleteModule(String code) {
        code = code.toUpperCase();

        modulesList.deleteModule(code);
    }

    /**
     * To enter into the module notes.
     *
     * @param code Module Code.
     * @throws Exception for moduleManager
     */
    public void enterModule(String code) throws Exception {
        code = code.toUpperCase();

        modulesList.enterModule(code);

    }

    private void importModules() {
        try {
            File f = new File(Constants.NOTES_PATH);
            if (f.createNewFile()) {
                final boolean b = f.setWritable(true);
                System.out.println(Constants.NOTES_FILE_NOT_FOUND);
            }
            HashMap<String, ArrayList<String>> modules = new HashMap<>();
            Scanner input = new Scanner(f);
            while (input.hasNext()) {
                String code = input.nextLine();
                ArrayList<String> messages = new ArrayList<>();
                String message = input.nextLine();
                while (!message.equals("-----")) {
                    messages.add(message);
                    message = input.nextLine();
                }
                modules.putIfAbsent(code, messages);
            }
            modulesList.importModules(modules);
        } catch (Exception e) {
            System.out.println("Couldn't import modules.");
        }
    }

    /**
     * Export modules when exiting app.
     * @throws IOException exception raised when exporting modules
     */
    public void exportModules() throws IOException {
        FileWriter fw = new FileWriter(Constants.NOTES_PATH);
        HashMap<String, ArrayList<String>> modules = modulesList.exportModules();
        modules.forEach((key, messages) -> {
            try {
                fw.write(key + "\n");
                for (String message : messages) {
                    fw.write(message + "\n");
                }
                fw.write("-----\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fw.close();
        System.out.println("Notes saved successfully.");
    }

    /**
     * Print all saved modules.
     */
    public void listModules() {
        System.out.println(Constants.LINE_BREAK);
        modulesList.listModules();
        System.out.println(Constants.LINE_BREAK);
    }
}
