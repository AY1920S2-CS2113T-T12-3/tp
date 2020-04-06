package studyarea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@author terrytay
class StudyAreaTest {

    StudyArea location1 = new StudyArea("mac commons", "utown", "nil", true, true,
            5);

    @Test
    void getAddress() {
        assertEquals("utown", location1.getAddress());
    }

    @Test
    void getFaculty() {
        assertEquals("nil", location1.getFaculty());
    }

    @Test
    void hasPort() {
        assertEquals(true, location1.hasPort());
    }

    @Test
    void isIndoor() {
        assertEquals(true, location1.isIndoor());
    }

    @Test
    void getMaxPax() {
        assertEquals(5, location1.getMaxPax());
    }

    @Test
    void getName() {
        assertEquals("mac commons", location1.getName());
    }
}