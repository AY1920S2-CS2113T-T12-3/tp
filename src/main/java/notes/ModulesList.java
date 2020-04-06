package notes;

import notes.modules.ModuleManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//@@author terrytay
public class ModulesList {
    static ModulesList instance = null;
    private HashMap<String, ArrayList<String>> modules;

    private ModulesList() {
        this.modules = new HashMap<>();
    }

    /**
     * Singleton check for null instance before initializing.
     * @return ModuleList
     */
    public static ModulesList getInstance() {
        if (instance == null) {
            instance = new ModulesList();
        }
        return instance;
    }

    /**
     * Create a module with code.
     *
     * @param code Module Code.
     */
    public void createModule(String code) {
        modules.putIfAbsent(code, new ArrayList<>());

        String success = String.format("%s has been created\n", code);
        System.out.println(success);
    }

    /**
     * Delete a module using its code.
     *
     * @param code Module code.
     */
    public void deleteModule(String code) {
        if (modules.containsKey(code)) {
            System.out.println("Are you sure you want to remove " + code
                    + "? [Y/N]");
            Scanner input = new Scanner(System.in);
            if (input.nextLine().contains("Y")) {
                modules.remove(code);
                System.out.println(code + " has been removed");
            } else {
                System.out.println("Remove operation has been cancelled");
            }
        } else {
            System.out.println("Module is not found.");
        }
    }

    /**
     * Retrieves a module's content from the module given the module code.
     * @param code module code
     * @return module's content
     */
    public ArrayList<String> getModule(String code) {
        if (!modules.containsKey(code)) {
            return null;
        }
        return modules.get(code);
    }

    /**
     * Enters the module interface of moduleManager.
     * @param code module code
     * @throws Exception for ModuleManager
     */
    public void enterModule(String code) throws Exception {
        if (getModule(code) == null) {
            System.out.println("Module not found.");
        } else {
            new ModuleManager(code, getModule(code));
        }
    }

    /**
     * Print all saved modules.
     */
    public void listModules() {
        if (modules.isEmpty()) {
            System.out.println("No modules have been added yet.");
        }
        System.out.println(modules.keySet());
    }

    public void importModules(HashMap<String, ArrayList<String>> modules) {
        this.modules = modules;
    }

    public HashMap<String, ArrayList<String>> exportModules() {
        return this.modules;
    }
}
