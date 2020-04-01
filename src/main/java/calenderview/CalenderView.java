package calenderview;

import exception.CalenderException;
import task.Task;
import ui.Ui;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.LinkedList;

import static ui.Constants.*;

//@@author NizarMohd
/**
 * This class deals with converting Tasks into Calender view.
 */
public class CalenderView {
    private HashMap<Integer, LinkedList<Task>> map;
    private  LocalDate firstDay;
    public  int month;
    public  int year;
    private  int lastDay;
    private  int[] daysOfMonths = new int[35];
    private Ui ui;

    /**
     * This constructs the class.
     * @param ui allows for interaction with the user.
     */
    public CalenderView(Ui ui) {
        this.ui = ui;
        getInput();
        this.firstDay = YearMonth.of(this.year, this.month).atDay(1);
        this.lastDay = this.firstDay.getMonth().length(this.firstDay.isLeapYear());
        processDates();
    }

    /**
     * This sets the mapping between days to Tasks.
     * @param inMap this is the incoming created by CalenderCommand.
     */
    public void setMap(HashMap<Integer, LinkedList<Task>> inMap) {
        this.map = inMap;
    }

    /**
     * This print the days header.
     */
    public void printDays() {
        this.ui.printOut(DIVIDER, true);
        for (int i = 0; i < MAX_COL; i++) {
            this.ui.printOut(COL + DAYS[i] + PADDING1, false);
        }
        this.ui.printOut(COL, true);
        this.ui.printOut(DIVIDER, true);
    }

    /**
     * This process the dates of the month into its supposed box.
     */
    public void processDates() {
        int index = this.firstDay.getDayOfWeek().getValue();
        index = index % MAX_COL;
        for (int i = 1; i <= this.lastDay; i++) {
            if (index >= 35) {
                index = 0;
            }
            this.daysOfMonths[index] = i;
            index++;
        }
    }

    private LinkedList<Task> processList(int day) {
        LinkedList<Task> tasks = this.map.get(day);
        if(tasks.size() > MAX_LIST_SIZE) {
            LinkedList<Task> temp = new LinkedList<>();
            for (int i = 0; i < MAX_LIST_SIZE; i++) {
                temp.add(tasks.get(i));
            }
            this.map.get(day).clear();
            this.map.get(day).addAll(temp);
            assert this.map.get(day) != null : MAP_CANNOT_BE_EMPTY;
        }
        return this.map.get(day);
    }
    /**
     * This prints the content to be displayed in the box.
     * @param row this is the row the box is at.
     * @param i this is the height of the box that is currently being printed.
     * @param j this is the day which the box is at.
     */
    public void printContent(int row, int i, int j) {
        int index = row * MAX_COL + j;
        int day = daysOfMonths[index];
        if (i == 0) {
            if (this.daysOfMonths[index] == 0) {
                this.ui.printOut(COL + SPACES + PADDING, false);
            } else if (this.daysOfMonths[index] > 9) {
                this.ui.printOut(COL + SPACES + PADDING3 + this.daysOfMonths[index], false);
            } else {
                this.ui.printOut(COL + SPACES + PADDING2 + this.daysOfMonths[index], false);
            }
        } else {
            if (map.containsKey(day)) {
                if (map.get(day).isEmpty()) {
                    this.ui.printOut(COL + SPACES + PADDING, false);
                } else {
                    LinkedList<Task> tasks = processList(day);
                    Task task = tasks.get(0);
                    tasks.removeFirst();
                    this.ui.printOut(COL + SPACE + task.getCalenderTaskDetails() + SPACE, false);
                }
            } else {
                this.ui.printOut(COL + SPACES + PADDING, false);
            }
        }
    }

    /**
     * This method prints the box itself.
     * @param row this is the row that the box is currently being printed.
     */
    public void printBox(int row) {
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                printContent(row, i, j);
            }
            this.ui.printOut(COL, true);
        }
        this.ui.printOut(DIVIDER, true);
    }

    /**
     * This prints the month which the calendar is being printed.
     */
    public void printCurrentMonth() {
        this.ui.printOut(TASKS_FOR + this.firstDay.getMonth().toString() + COMMA +  this.firstDay.getYear(),
                true);
    }

    /**
     * This checks if the month entered by user is correct.
     * @param in this is the input by user.
     * @throws CalenderException this is the exception thrown when user entered the month wrongly.
     */
    public void checkMonth(String in) throws CalenderException {
        try {
            int inMonth = Integer.parseInt(in);
            if (inMonth < JAN || inMonth > DEC) {
                throw new CalenderException(INVALID_MONTH);
            }
            this.month = inMonth;
        } catch (NumberFormatException e) {
            throw new CalenderException(NON_INTEGER_MONTH);
        }
    }

    /**
     * This method checks the year entered by the user.
     * @param in This is the input entered by the user.
     * @throws CalenderException is thrown when user enters the year wrongly.
     */
    public void checkYear(String in) throws CalenderException {
        try {
            int inYear = Integer.parseInt(in);
            if (inYear < 2020) {
                throw new CalenderException(INVALID_YEAR);
            }
            this.year = inYear;
        } catch (NumberFormatException e) {
            throw new CalenderException(NON_INTEGER_YEAR);
        }
    }

    /**
     * This method gets the input from the user.
     */
    public void getInput() {
        this.ui.printMessage(ENTER_DESIRED_MONTH);
        String temp = this.ui.getUserIn();
        String[] input = temp.split(MULTIPLE_WHITE_SPACES);
        if (input[0].equals(NOW)) {
            this.month = LocalDate.now().getMonthValue();
            this.year = LocalDate.now().getYear();
        } else {
            try {
                checkMonth(input[0]);
                checkYear(input[1]);
            } catch (Exception e) {
                this.ui.printLine();
                System.err.println(e.getMessage());
                this.ui.printLine();
            }
        }
    }

    /**
     * This method prints the calendar.
     */
    public void printCalender() {
        printCurrentMonth();
        printDays();
        for (int i = 0; i < MAX_ROW; i++) {
            printBox(i);
        }
    }

}
