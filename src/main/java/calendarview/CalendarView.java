package calendarview;

import exception.CalendarException;
import task.Task;
import ui.Ui;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.LinkedList;
import static ui.Constants.COL;
import static ui.Constants.COMMA;
import static ui.Constants.DAYS;
import static ui.Constants.DEC;
import static ui.Constants.DIVIDER;
import static ui.Constants.ENTER_DESIRED_MONTH;
import static ui.Constants.INVALID_MONTH_RANGE;
import static ui.Constants.INVALID_YEAR;
import static ui.Constants.JAN;
import static ui.Constants.MAP_CANNOT_BE_EMPTY;
import static ui.Constants.MAX_COL;
import static ui.Constants.MAX_LIST_SIZE;
import static ui.Constants.MAX_ROW;
import static ui.Constants.MULTIPLE_WHITE_SPACES;
import static ui.Constants.INVALID_MONTH;
import static ui.Constants.NON_INTEGER_YEAR;
import static ui.Constants.NOW;
import static ui.Constants.PADDING;
import static ui.Constants.PADDING1;
import static ui.Constants.PADDING2;
import static ui.Constants.PADDING3;
import static ui.Constants.SPACE;
import static ui.Constants.SPACES;
import static ui.Constants.TASKS_FOR;

//@@author NizarMohd
/**
 * This class deals with converting Tasks into Calendar view.
 */
public class CalendarView {
    private HashMap<Integer, LinkedList<Task>> map;
    private  LocalDate firstDay;
    public  int month = -1;
    public  int year = -1;
    private  int lastDay;
    private  int[] daysOfMonths = new int[35];
    private Ui ui;

    /**
     * This constructs the class.
     * @param ui allows for interaction with the user.
     */
    public CalendarView(Ui ui) {
        this.ui = ui;
        getInput();                                     // year and month will be set if user enters correctly.
        if (this.year != -1 && this.month != -1) {       // check if year and month is set
            this.setFirstDay();
            this.setLastDay();
            processDates();
        }
    }

    /**
     * This sets the mapping between days to Tasks.
     * @param inMap this is the incoming created by CalendarCommand.
     */
    public void setMap(HashMap<Integer, LinkedList<Task>> inMap) {
        this.map = inMap;
    }


    /**
     * This method sets the first day val. This prevent double error messages when user enters invalid command.
     */
    private void setFirstDay() {
        this.firstDay = YearMonth.of(this.year, this.month).atDay(1);
    }

    /**
     * This method sets the last day val. This prevent double error messages when user enters invalid command.
     */
    private void setLastDay() {
        this.lastDay = this.firstDay.getMonth().length(this.firstDay.isLeapYear());
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
        if (tasks.size() > MAX_LIST_SIZE) {
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
                    this.ui.printOut(COL + SPACE + task.getCalendarTaskDetails() + SPACE, false);
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
     * @throws CalendarException this is the exception thrown when user entered the month wrongly.
     */
    public void setMonth(String in) throws CalendarException {
        int monthVal;
        try {
            int inMonth = Integer.parseInt(in);
            if (inMonth < JAN || inMonth > DEC) {
                throw new CalendarException(INVALID_MONTH_RANGE);
            }
            this.month = inMonth;
        } catch (NumberFormatException e) {
            throw new CalendarException(INVALID_MONTH);
        }
    }

    /**
     * This method checks the year entered by the user.
     * @param in This is the input entered by the user.
     * @throws CalendarException is thrown when user enters the year wrongly.
     */
    public void setYear(String in) throws CalendarException {
        try {
            int inYear = Integer.parseInt(in);
            if (inYear < 2020) {
                throw new CalendarException(INVALID_YEAR);
            }
            this.year = inYear;
        } catch (NumberFormatException e) {
            throw new CalendarException(NON_INTEGER_YEAR);
        }
    }

    /**
     * This method gets the input from the user.
     */
    public void getInput() {
        this.ui.printLine();
        this.ui.printMessage(ENTER_DESIRED_MONTH);
        this.ui.printLine();
        boolean isWrongCommand = true;
        while (isWrongCommand) {
            String temp = this.ui.getUserIn().toLowerCase();
            String[] input = temp.split(MULTIPLE_WHITE_SPACES);
            if (input[0].equals(NOW)) {
                this.month = LocalDate.now().getMonthValue();
                this.year = LocalDate.now().getYear();
            } else {
                try {
                    setMonth(input[0]);
                    setYear(input[1]);
                    isWrongCommand = false;
                } catch (Exception e) {
                    this.ui.printLine();
                    this.ui.printMessage(e.getMessage());
                    this.ui.printLine();
                }
            }
        }
    }

    /**
     * This method prints the calendar.
     */
    public void printCalendar() {
        printCurrentMonth();
        printDays();
        for (int i = 0; i < MAX_ROW; i++) {
            printBox(i);
        }
    }

}
