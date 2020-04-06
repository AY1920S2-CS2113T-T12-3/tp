package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@author GanapathySanathBalaji

class SchedulableTaskTest {

    @Test
    void scheduleTaskInformation() throws Exception {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {"Sample task", "f 1", "d 2"};
        newTaskToBeScheduled.setDetails(taskDetails);
        assertEquals(newTaskToBeScheduled.taskDescription, "Sample task");
        assertEquals(newTaskToBeScheduled.numberOfDaysRequiredToFinishTask,1);
        assertEquals(newTaskToBeScheduled.numberOfDaysLeft,2);
    }

    @Test
    void scheduleTask_invalidFormat_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();

        String[] taskDetails = {""};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }

        taskDetails = new String[]{"", ""};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }

        taskDetails = new String[]{"", "", "", ""};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }


        taskDetails = new String[]{"Sample task", "", ""};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }

        taskDetails = new String[]{"Sample task", "f1", ""};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }

        taskDetails = new String[]{"Sample task", "f 1", "d2"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }

        taskDetails = new String[]{"Sample task", "d 1", "f 2"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Please follow the format specified",e.getMessage());
        }
    }

    @Test
    void scheduleTask_emptyDescription_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {" ", "f 1", "d 2"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Description of task shouldn't be empty", e.getMessage());
        }
    }

    @Test
    void scheduleTask_emptyDaysToFinish_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {"Sample task", "f ", "d 2"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days to finish task should be an integer", e.getMessage());
        }
    }

    @Test
    void scheduleTask_emptyDaysLeft_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {"Sample task", "f 1", "d "};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days left should be an integer", e.getMessage());
        }
    }

    @Test
    void scheduleTask_nonPositiveNumberOfDaysToFinish_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {"Sample task", "f 0", "d 2"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days to finish should be greater than 1", e.getMessage());
        }

        taskDetails = new String[]{"Sample task", "f -1", "d 2"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days to finish should be greater than 1", e.getMessage());
        }
    }

    @Test
    void scheduleTask_nonPositiveNumberOfDaysLeft_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {"Sample task", "f 1", "d 0"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days left should be greater than 1", e.getMessage());
        }

        taskDetails = new String[]{"Sample task", "f 1", "d -1"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days left should be greater than 1", e.getMessage());
        }
    }

    @Test
    void scheduleTask_DaysLeftLessThanDeadline_throwException() {
        SchedulableTask newTaskToBeScheduled = new SchedulableTask();
        String[] taskDetails = {"Sample task", "f 2", "d 1"};
        try {
            newTaskToBeScheduled.setDetails(taskDetails);
        } catch (Exception e) {
            assertEquals("Number of days left should not be lesser than number of days to finish the task",
                    e.getMessage());
        }
    }
}