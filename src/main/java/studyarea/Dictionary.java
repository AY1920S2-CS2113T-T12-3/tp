package studyarea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class allows for User to loosely search certain names, address or faculties of StudyAreas.
 */
public class Dictionary {

    private static final String FILEPATH = "library" + File.separator + "dictionary.txt";
    private static final String DELIMITER = "~";
    private static HashMap<String, String> dictionary = new HashMap<>();

    /**
     * This method loads the dictionary mapping from dictionary.text.
     * @throws FileNotFoundException if the file cannot be found.
     */

    public static void loadDictionary() throws FileNotFoundException {
        Scanner in = new Scanner(new File(FILEPATH));
        while (in.hasNextLine()) {
            String userIn = in.nextLine();
            String[] buffer = userIn.split(DELIMITER);
            int i = 0;
            String out = null;
            for (String value : buffer) {
                if (i == 0) {
                    out = value;
                } else {
                    dictionary.put(value, out);
                }
                i++;
            }
        }
        in.close();
    }

    /**
     * This method finds a mapping from User input to a either StudyArea's name, address, or faculty.
     * @param key this is the User input.
     * @return either StudyArea's name, address, or faculty if mapping is found, else return null.
     */

    public static String parseKey(String key) { //this method will be used within String.contains() method
        String out = DELIMITER;                // Since .contains() cannot have null as an argument, out is initialised
        if (dictionary.containsKey(key)) {      // with delimiter because mapped data does not contain delimiter.
            out = dictionary.get(key);
        }
        return out;
    }
}
