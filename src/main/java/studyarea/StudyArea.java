package studyarea;

import ui.Ui;

import static java.lang.System.lineSeparator;
import static ui.Constants.MAX_LINE_LENGTH;
import static ui.Constants.TAB;


/**
 * This is the StudyArea class. All study area is stored as a Study Area object.
 */

public class StudyArea {
    private String name;
    private String address;
    private String faculty;
    private boolean hasPort;
    private boolean isIndoor;
    private int maxPax;

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

    public StudyArea(String name, String address, String faculty, boolean hasPort,
                     boolean isIndoor, int maxPax) {
        this.name = name;
        this.address = address.trim();
        this.faculty = faculty;
        this.hasPort = hasPort;
        this.isIndoor = isIndoor;
        this.maxPax = maxPax;
    }

    /**
     * This is the getter for the name attribute.
     *
     * @return general name of the StudyArea.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This is the getter for the address attribute.
     *
     * @return physical address of the StudyArea.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * This is the getter for the faculty attribute.
     *
     * @return the name of the faculty that the StudyArea is located at.
     */
    public String getFaculty() {
        return this.faculty;
    }

    /**
     * This is the getter for the hasPort attribute.
     *
     * @return true if the StudyArea has ports and false if otherwise.
     */
    public boolean hasPort() {
        return this.hasPort;
    }

    /**
     * This is the getter for the isIndoor attribute.
     *
     * @return true if StudyArea is indoors and false if otherwise.
     */
    public boolean isIndoor() {
        return this.isIndoor;
    }

    /**
     * This is the getter for the maxPax attribute.
     *
     * @return maximum number of pax the StudyArea can hold.
     */
    public Integer getMaxPax() {
        return this.maxPax;
    }

    /**
     * Prints the StudyArea into a standard String format.
     * @return String value of all the attributes of the specific StudyArea.
     */
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

}