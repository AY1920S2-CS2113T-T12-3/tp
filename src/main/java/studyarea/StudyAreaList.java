package studyarea;

import java.util.ArrayList;
import static ui.Constants.DUPLICATE_FLAGS;
import static ui.Constants.FLAG;
import static ui.Constants.INDOOR_FLAG;
import static ui.Constants.MULTIPLE_WHITE_SPACES;
import static ui.Constants.NON_POSITIVE_INTEGER;
import static ui.Constants.NOT_INTEGER;
import static ui.Constants.NO_SIZE_INDICATED;
import static ui.Constants.ONLY_FLAG;
import static ui.Constants.OUTDOOR_FLAG;
import static ui.Constants.PORTS_FLAG;
import static ui.Constants.SIZE_FLAG;
import static ui.Constants.SPACE;
import static ui.Constants.WRONG_FLAG_ARGUMENT_POSITION;
import static ui.Constants.WRONG_FLAG_USAGE;

/**
 * This is the class that stores and manages all of the Study Areas in location.txt
 */

public class StudyAreaList {
    private ArrayList<StudyArea> studyAreaList;

    // Assigns studyAreaList into object's studyAreaList.
    public StudyAreaList(ArrayList<StudyArea> studyAreaList) {
        this.studyAreaList = studyAreaList;
    }

    /**
     * Gets the list of all the Locations in location.txt
     *
     * @return ArrayList of StudyAreas.
     */
    public ArrayList<StudyArea> getStudyAreaList() {
        return this.studyAreaList;
    }


    /**
     * This method checks for duplicate flags.
     * @param flag this is the array of flags in the system.
     * @param index this is the index referring to the specific flag to check for duplicate.
     * @throws IllegalStudyAreaException if flag is not null, ie: if flag has already been mentioned.
     */
    public static void checkDuplicate(String[] flag, int index) throws IllegalStudyAreaException {
        if (flag[index] != null) {
            throw new IllegalStudyAreaException(DUPLICATE_FLAGS);
        }
    }

    /**
     * This method check if command entered is only flags.
     * @param commands This is the string of commands entered by User.
     * @param index This is the index in which the method is check if only flag exist.
     * @throws IllegalStudyAreaException if only flag is entered by user.
     */

    public static void checkOnlyFlag(String[] commands, int index) throws IllegalStudyAreaException {
        if (commands[index].length() == 1) {
            throw new IllegalStudyAreaException(ONLY_FLAG);
        }
    }

    /**
     * This method checks if the command after the size flag is a valid integer.
     * @param commands this is the array of commands entered.
     * @param index this is the index where the size flag is.
     * @throws IllegalStudyAreaException if command entered is not a valid integer.
     */
    public static void checkInteger(String[] commands, int index) throws IllegalStudyAreaException {

        try {                                     // try block is to test if command is integer
            int size = Integer.parseInt(commands[index + 1]);
            if (size <= 0) {                     // check if integer is positive, else throw exception.
                throw new IllegalStudyAreaException(NON_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException e) {       // catch if command is not integer then throw exception
            throw new IllegalStudyAreaException(NOT_INTEGER);
        } catch (ArrayIndexOutOfBoundsException e) {   // catch if no string exist after "-s" and throw exception
            throw new IllegalStudyAreaException(NO_SIZE_INDICATED);
        }

    }

    /**
     * This method validate flags based on User input.
     *
     * @param flags this is the array of flags.
     * @param commands this is the full command entered by Users.
     * @param index this is the index which the method is assigning the commands into the flags array.
     * @param isNotFlag this is the boolean value that checks if the command entered is a flag.
     * @throws IllegalStudyAreaException if user enters command wrongly.
     */
    public static void checkFlag(String[] flags, String[] commands, int index, boolean isNotFlag) throws
            IllegalStudyAreaException {                //isNotFlag is used to track previous instances of "-"

        if (commands[index].equals(SIZE_FLAG)) {   // for instances of "-s", check if next string is integer or null.
            checkDuplicate(flags, 0);
            checkInteger(commands, index);         // check if subsequent command is a valid integer.
        } else if (commands[index].contains(FLAG)) { // for instances "-" ,
            checkOnlyFlag(commands, index);             // check if only "-" exist, if true, then throw exception
            switch (commands[index].charAt(1)) {        // if "-p", "-i" , "-o" then check if duplicate. Else, throw
            case 'p':                               // exception for wrong usage of flag
                checkDuplicate(flags, 2);
                break;
            case 'i':
            case 'o':
                checkDuplicate(flags, 3);
                break;
            default:
                throw new IllegalStudyAreaException(WRONG_FLAG_USAGE);
            }
        } else {                                         // if no instances of "-" or "-s"
            if (!isNotFlag) {                            // and if there exist previous instances of "-" (i.e: -p EA)
                throw new IllegalStudyAreaException(WRONG_FLAG_ARGUMENT_POSITION);  // throw exception
            }
        }
    }

    /**
     * Obtains all the supported flags in this organiser app.
     *
     * @param commands This is the User commands that has been split by spaces.
     * @return special purpose String Array of a fixed size of 5 and fixed values where :<br>
     *          index 0 : "-s"<br>
     *          index 1 : Integer value of the size indicated.<br>
     *          index 2 : "-p"<br>
     *          index 3 : "-i" or "-o" , depends on user input<br>
     *          index 4: search key entered by User<br>
     * @throws IllegalStudyAreaException when arguments for flags are invalid.
     */
    public String[] getFlagsInfo(String[] commands) throws IllegalStudyAreaException {

        String[] flags = new String[5];
        StringBuilder name = new StringBuilder();
        boolean isNotFlag = true;                             // to keep track of instance "-" is input.
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(SIZE_FLAG)) {
                isNotFlag = false;                              // update isNotFlag as false because command is a flag
                checkFlag(flags, commands, i, false); // pass false instead of isNotFlag as only boolean logic
                flags[0] = SIZE_FLAG;
                flags[1] = Integer.toString(Integer.parseInt(commands[i + 1]));
                i++;
            } else if (commands[i].contains(FLAG)) {
                isNotFlag = false;
                checkFlag(flags, commands, i,false);
                switch (commands[i].charAt(1)) {
                case 'p':
                    flags[2] = PORTS_FLAG;
                    break;
                case 'i':
                    flags[3] = INDOOR_FLAG;
                    break;
                case 'o':
                    flags[3] = OUTDOOR_FLAG;
                    break;
                default:
                    throw new IllegalStudyAreaException(WRONG_FLAG_USAGE);
                }
            } else {                                              // if no previous instances of "-"
                if (isNotFlag) {                                  // and if input is not a flag
                    name.append(commands[i]).append(SPACE);    // concatenate subsequent input that pass the control
                    flags[4] = name.toString().trim();            // flag
                } else {
                    checkFlag(flags, commands, i, false); // if has previous instances of "-" and input is not
                }                                                  // flag, pass false to throw exception.
            }
        }
        return flags;
    }

    /**
     * Checks if search key is found in Study Area's Name and Faculty attributes.
     * @param name This is the Study Area's Name Attribute.
     * @param address This is the Study Area's Address Attribute.
     * @param faculty This is the Study Area's Faculty Attribute.
     * @param key This is the search key entered by User.
     * @return True if can be found in either case. False if not found in both cases.
     */

    public static boolean containsKey(String name, String address, String faculty, String key) {
        if (name.contains(key) || name.contains(Dictionary.parseKey(key))) {
            return true;
        }
        if (address.contains(key) || address.contains(Dictionary.parseKey(key))) {
            return true;
        }
        return faculty.contains((key)) || faculty.contains(Dictionary.parseKey(key));
    }

    /**
     * Finds a list of StudyAreas based on User requirements.
     *
     * @param userIn This is the requirement entered by User
     * @return ArrayList of StudyAreas
     * @throws IllegalStudyAreaException if User enters invalid commands.
     */
    public ArrayList<StudyArea> searchList(String userIn) throws IllegalStudyAreaException {
        String[] temp = userIn.split(MULTIPLE_WHITE_SPACES);
        String[] flags = getFlagsInfo(temp);
        ArrayList<StudyArea> availStudyAreas = new ArrayList<>();
        for (StudyArea studyArea : this.studyAreaList) {
            boolean isAvail = true;
            int index = 0;
            for (String flag : flags) {
                if (flag != null && isAvail && index != 1) {
                    switch (flag) {
                    case PORTS_FLAG:
                        isAvail = studyArea.hasPort();
                        break;
                    case INDOOR_FLAG:
                        isAvail = studyArea.isIndoor();
                        break;
                    case OUTDOOR_FLAG:
                        isAvail = !studyArea.isIndoor();
                        break;
                    case SIZE_FLAG:  // allows user to find by capacity <= MaxPax
                        isAvail = Integer.parseInt(flags[1]) <= studyArea.getMaxPax();
                        break;
                    default:      // toLowerCase() so casing does not affect matching
                        isAvail = containsKey(studyArea.getName().toLowerCase(), studyArea.getAddress().toLowerCase(),
                                studyArea.getFaculty().toLowerCase(), flags[4].toLowerCase());
                        break;
                    }
                    index++;
                }
            }
            if (isAvail) {
                availStudyAreas.add(studyArea);
            }
        }
        return availStudyAreas;
    }
}