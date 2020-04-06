package studyarea;

import exception.IllegalStudyAreaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@@author terrytay
class StudyAreaListTest {
    /**
     * An exception pertaining to duplicate flag should be raised if the string at flag[index] is not null.
     * A dummy array of flags is created, and the first flag is accessed and used it to check duplicate
     * in the same location. The expected outcome is to return an exception since the string is not null.
     */
    @Test
    void checkDuplicate_gotDuplicate_raiseException() {
        String[] flag = { "-a", "-b"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkDuplicate(flag, 0));
    }

    /**
     * An exception pertaining to using only hyphen when declaring a flag.
     * A dummy array is made with a flag inside that has no hyphen character. The expected outcome is to return
     * an exception since the input flag has only hyphen.
     */
    @Test
    void checkOnlyFlag_onlyHyphenSign_raiseException() {
        String[] commands = {"-"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkOnlyFlag(commands, 0));
    }

    /**
     * An exception pertaining to either wrong flag position or invalid flag is raised when user
     * enters a flag that does not exist or user enters the flag before the search terms.
     * The expected outcome is to return an exception as this test case inputs an invalid flag.
     */
    @Test
    void checkFlag_FlagDoesNotExist_raiseException() {
        String[] commands = {"MacCommons", "-z"};
        String[] flags = {null, null, null, null, "MacCommons"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkFlag(flags, commands,
                1, false));
    }

    //@@author NizarMohd
    /**
     * An exception pertaining to non Integer commands after using "-s".
     * The expected outcome is to return an exception as the size has to be an integer.
     */
    @Test
    void checkInteger_nonIntegerSize_raiseException() {
        String[] commands = { "-s", "nonInteger"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkInteger(commands,
                0));
    }

    /**
     * An exception pertaining to wrong position of flags when entering commands.
     * The expected outcome is to return an exception as flags must come after location/name.
     */
    @Test
    void checkFlag_wrongFlagsPosition_raiseException() {
        String[] commands = { "-i", "EA"};
        String[] flags = { null, null, null, "-i", "EA"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkFlag(flags, commands,
                1, false));
    }

}