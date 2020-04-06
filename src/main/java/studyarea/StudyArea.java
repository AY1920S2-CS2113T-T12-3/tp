package studyarea;

import ui.Ui;

import java.security.SecureRandom;
import static java.lang.System.lineSeparator;
import static ui.Constants.MAX_LINE_LENGTH;
import static ui.Constants.TAB;


/**
 * This is the StudyArea class. All study area is stored as a Study Area object.
 */
//@@author terrytay
public class StudyArea {
    private String name;
    private String address;
    private String faculty;
    private boolean hasPort;
    private boolean isIndoor;
    private int maxPax;
    private boolean isAvail;

    /**
     * Constructs a StudyArea class for a study area with its information
     * Precondition: 'All variables have to be filled.
     *
     * @param name name of StudyArea
     * @param address address of StudyArea
     * @param faculty faculty of StudyArea
     * @param hasPort true for availability of ports, else false
     * @param isIndoor true for indoor, else false
     * @param maxPax maximum number of seats for this StudyArea
     */
    //@@author terrytay
    public StudyArea(String name, String address, String faculty, boolean hasPort,
                     boolean isIndoor, int maxPax) {
        this.name = name;
        this.address = address.trim();
        this.faculty = faculty;
        this.hasPort = hasPort;
        this.isIndoor = isIndoor;
        this.maxPax = maxPax;
        this.isAvail = checkAvail();
    }

    /**
     * This method randomly assigns availability.
     * @return boolean value based random.nextBoolean() output.
     */
    //@@author terrytay
    public boolean checkAvail() {
        SecureRandom random = new SecureRandom();
        return random.nextBoolean();
    }

    /**
     * This method retrieves the availability of that study area.
     * @return a boolean value based on isAvail.
     */
    //@@author terrytay
    public boolean getIsAvail() {
        return this.isAvail;
    }

    /**
     * This is the getter for the name attribute.
     *
     * @return general name of the StudyArea.
     */
    //@@author terrytay
    public String getName() {
        return this.name;
    }

    /**
     * This is the getter for the address attribute.
     *
     * @return physical address of the StudyArea.
     */
    //@@author terrytay
    public String getAddress() {
        return this.address;
    }

    /**
     * This is the getter for the faculty attribute.
     *
     * @return the name of the faculty that the StudyArea is located at.
     */
    //@@author terrytay
    public String getFaculty() {
        return this.faculty;
    }

    /**
     * This is the getter for the hasPort attribute.
     *
     * @return true if the StudyArea has ports and false if otherwise.
     */
    //@@author terrytay
    public boolean hasPort() {
        return this.hasPort;
    }

    /**
     * This is the getter for the isIndoor attribute.
     *
     * @return true if StudyArea is indoors and false if otherwise.
     */
    //@@author terrytay
    public boolean isIndoor() {
        return this.isIndoor;
    }

    /**
     * This is the getter for the maxPax attribute.
     *
     * @return maximum number of pax the StudyArea can hold.
     */
    //@@author terrytay
    public Integer getMaxPax() {
        return this.maxPax;
    }

    /**
     * Prints the StudyArea into a standard String format.
     * @return String value of all the attributes of the specific StudyArea.
     */
    //@@author NizarMohd
    public String toString() {
        String text = TAB + "Name: " + this.name + lineSeparator()
                + Ui.formatMessage("Address: " + this.address, MAX_LINE_LENGTH)
                + lineSeparator() + TAB
                + "Faculty: " + this.faculty + lineSeparator() + TAB
                + "Port: " + this.hasPort + lineSeparator() + TAB
                + "Indoor: " + this.isIndoor + lineSeparator() + TAB
                + "Maximum number of Pax: " + this.maxPax;
        String line = TAB + "__________________________________________________________";
        return line + lineSeparator() + text + lineSeparator() + line;
    }

    /**
     * Checks if search key is found in Study Area's Name and Faculty attributes.
     * @param key This is the search key entered by User.
     * @return True if can be found in either case. False if not found in both cases.
     */
    //@@author terrytay
    public boolean containsSearchKey(String key) {
        if (this.name.toLowerCase().contains(key) || this.name.toLowerCase().contains(Dictionary.parseKey(key))) {
            return true;
        }
        if (this.address.toLowerCase().contains(key) || this.address.toLowerCase().contains(Dictionary.parseKey(key))) {
            return true;
        }
        return this.faculty.toLowerCase().contains((key))
                || this.faculty.toLowerCase().contains(Dictionary.parseKey(key));
    }

    /**
     * This method checks if the maximum size of the study area is capable of containing the desired size of people
     * stated by the User.
     * @param size this is the size stated by the user.
     * @return True if the size stated by the user is smaller than or equals to the maximum size of the Study Area.
     */
    //@@author terrytay
    public boolean isSizeCapable(String size) {
        return  Integer.parseInt(size) <= this.maxPax;
    }
}