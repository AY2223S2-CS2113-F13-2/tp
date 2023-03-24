package seedu.brokeMan.entry.expense;

import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.EntryList;
import seedu.brokeMan.parser.StringToTime;
import seedu.brokeMan.save.SaveExpense;
import seedu.brokeMan.ui.Ui;
import seedu.brokeMan.entry.Category;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ExpenseList extends EntryList {
    public static final LinkedList<Entry> expenseList = new LinkedList<>();
    //private final EntryList expenseList;

    /**
     * Adds new expense to the list
     *
     * @param newExpense new expense to be added
     */
    public static void addExpense(Expense newExpense) {
        addEntry(newExpense, expenseList);
    }

    /**
     * lists out expenses in the list
     */

    public static void listExpense(Optional<String> date) {
        int year = StringToTime.createYearFromString(date);
        Month month = StringToTime.createMonthFromString(date);

        List<Entry> expenseOfDate = getExpensesMadeInMonth(year, month);
        String dateInString = StringToTime.createDateString(year, month);

        Ui.showToUser("Here are the expenses you have made for " + dateInString + ".");
        listEntry(expenseOfDate);
        Ui.showToUser("Total expenses: $" + getEntryListSum(expenseOfDate));
        Ui.showToUserWithLineBreak("");
    }

    public static void listExpense() {
        Ui.showToUser("Here are the expenses you have made.");
        listEntry(expenseList);
        Ui.showToUser("Total expenses: $" + getEntryListSum(expenseList));
        Ui.showToUserWithLineBreak("");
    }

    /**
     * deletes specific expense in the list
     *
     * @param expenseIndex Index of the expense in the list
     */
    public static void deleteExpense(int expenseIndex) {
        deleteEntry(expenseIndex, expenseList);
    }


    /**
     * Edits the description of the expense specified by the index in the list
     *
     * @param expenseIndex index of the expense in the list
     * @param newEntry     new description that will replace current description
     */
    public static void editExpense(int expenseIndex, String newEntry) {
        editEntryDescription(expenseIndex, newEntry, expenseList);
    }

    /**
     * Edits the amount of expense specified by the index in the list
     * @param expenseIndex index of the expense in the list
     * @param newEntry     new amount that will replace the current amount
     */
    public static void editExpense(int expenseIndex, Double newEntry) {
        editEntryCost(expenseIndex, newEntry, expenseList);
    }

    /**
     * Edits the time of expense specified by the index in the list
     *
     * @param expenseIndex index of the expense in the list
     * @param newEntry     new time that will replace the current amount
     */
    public static void editExpense(int expenseIndex, LocalDateTime newEntry) {
        editEntryTime(expenseIndex, newEntry, expenseList);
    }

    public static void editExpense(int expenseIndex, Category newEntry) {
        editEntryCategory(expenseIndex, newEntry, expenseList);
    }

    /**
     * Sorts expenses by amount, from largest to smallest
     */
    public static void sortExpensesByAmount() {
        sortEntriesByAmount(expenseList);
        Ui.showToUser("Total expenses: $" + getEntryListSum(expenseList));
        Ui.showToUserWithLineBreak("");
    }

    /**
     * Sorts expenses by date, from latest to oldest
     */
    public static void sortExpensesByDate() {
        sortEntriesByDate(expenseList);
        Ui.showToUser("Total expenses: $" + getEntryListSum(expenseList));
        Ui.showToUserWithLineBreak("");
    }


    public static void findExpenseByCategory(Category category) {
        findEntriesByCategory(category, expenseList);
    }

    public static List<Entry> getExpensesMadeInMonth(int year, Month month) {
        return selectEntryForDate(year, month, expenseList);
    }
}
