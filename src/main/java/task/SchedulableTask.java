package task;

//@@author GanapathySanathBalaji

import exception.command.SchedulableTaskDaysLeftNotIntegerException;
import exception.command.SchedulableTaskDaysLeftNotPositiveException;
import exception.command.SchedulableTaskDaysToFinishMoreThanDaysLeftException;
import exception.command.SchedulableTaskDaysToFinishNotIntegerException;
import exception.command.SchedulableTaskDaysToFinishNotPositiveException;
import exception.command.SchedulableTaskEmptyDescriptionException;
import exception.command.SchedulableTaskFormatNotFollowedException;

public class SchedulableTask {

    public static final char SINGLE_SPACE = ' ';
    public static final char DAYS_LEFT_IDENTIFIER = 'd';
    public static final char DAYS_TO_FINISH_IDENTIFIER = 'f';
    public String taskDescription;
    public int numberOfDaysLeft;
    public int numberOfDaysRequiredToFinishTask;

    /**
     * Sets the details of Schedulable Task object with the information provided in the splitDetails.
     *
     * @param splitDetails Contains all the details of the schedulable task.
     * @throws Exception If the details entered are invalid.
     */
    public void setDetails(String[] splitDetails) throws Exception {
        if (splitDetails.length != 3) {
            throw new SchedulableTaskFormatNotFollowedException();
        }
        setDescription(splitDetails[0]);
        setNumberOfDaysToFinish(splitDetails[1]);
        setNumberOfDaysLeft(splitDetails[2]);
    }

    /**
     * Sets the numberOfDaysLeft field from the user given data.
     *
     * @param numberOfDaysLeft User given input for number of days left.
     * @throws Exception If the number entered is not positive or is less than the number of days to finish the task.
     */
    private void setNumberOfDaysLeft(String numberOfDaysLeft) throws Exception {
        try {
            if (numberOfDaysLeft.charAt(0) != DAYS_LEFT_IDENTIFIER
                    || numberOfDaysLeft.charAt(1) != SINGLE_SPACE) {
                throw new SchedulableTaskFormatNotFollowedException();
            }
            this.numberOfDaysLeft = Integer.parseInt(numberOfDaysLeft.substring(2).trim());
            if (this.numberOfDaysLeft < 1) {
                throw new SchedulableTaskDaysLeftNotPositiveException();
            }
            if (this.numberOfDaysLeft < this.numberOfDaysRequiredToFinishTask) {
                throw new SchedulableTaskDaysToFinishMoreThanDaysLeftException();
            }
        } catch (NumberFormatException e) {
            throw new SchedulableTaskDaysLeftNotIntegerException();
        } catch (IndexOutOfBoundsException e) {
            throw new SchedulableTaskFormatNotFollowedException();
        }
    }

    /**
     * Sets the numberOfDaysToFinish field from the user given data.
     *
     * @param numberOfDaysToFinish User given input for number of days to finish task.
     * @throws Exception If the number entered is not positive.
     */
    private void setNumberOfDaysToFinish(String numberOfDaysToFinish) throws Exception {
        try {
            if (numberOfDaysToFinish.charAt(0) != DAYS_TO_FINISH_IDENTIFIER
                    || numberOfDaysToFinish.charAt(1) != SINGLE_SPACE) {
                throw new SchedulableTaskFormatNotFollowedException();
            }
            this.numberOfDaysRequiredToFinishTask = Integer.parseInt(numberOfDaysToFinish.substring(2)
                    .trim());
            if (this.numberOfDaysRequiredToFinishTask < 1) {
                throw new SchedulableTaskDaysToFinishNotPositiveException();
            }
        } catch (NumberFormatException e) {
            throw new SchedulableTaskDaysToFinishNotIntegerException();
        } catch (IndexOutOfBoundsException e) {
            throw new SchedulableTaskFormatNotFollowedException();
        }
    }

    /**
     * Sets the input from the user given input.
     *
     * @param description User given input for description.
     * @throws SchedulableTaskEmptyDescriptionException If the description is empty.
     */
    private void setDescription(String description) throws SchedulableTaskEmptyDescriptionException {
        if (description.isBlank()) {
            throw new SchedulableTaskEmptyDescriptionException();
        }
        this.taskDescription = description;
    }

}
