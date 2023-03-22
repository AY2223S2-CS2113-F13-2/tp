package seedu.brokeMan.entry.expense;

import seedu.brokeMan.Save.SaveExpense;
import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.EntryList;
import seedu.brokeMan.ui.Ui;

import java.util.LinkedList;

public class Expenses extends EntryList {
    private static final LinkedList<Entry> expenseList = new LinkedList<>();
    //private final EntryList expenseList;

    /**
     * Adds new expense to the list
     *
     * @param newExpense new expense to be added
     */
    public static void addExpense(Expense newExpense) {
        addEntry(newExpense, expenseList);
        SaveExpense.writeFile(expenseList);
    }

    /**
     * lists out expenses in the list
     */
    public static void listExpense() {
        Ui.showToUser("Here are the expenses you have made.");
        listEntry(expenseList);
        Ui.showToUser("Total expenses: $" + getTotalAmount(expenseList));
        Ui.showToUserWithLineBreak("");
    }

    public static double getTotalExpense() {
        return getTotalAmount(expenseList);
    }

    /**
     * deletes specific expense in the list
     *
     * @param expenseIndex Index of the expense in the list
     */
    public static void deleteExpense(int expenseIndex) {
        deleteEntry(expenseIndex, expenseList);
        SaveExpense.writeFile(expenseList);
    }

    /**
     * Edits a specific index in the list
     *
     * @param type entry type of the expense to be changed
     * @param expenseIndex index of the expense in the list
     * @param newEntry new entry that will replace current entry
     */
    public static void editExpenseCost(String type, int expenseIndex, double newEntry) {
        editEntry(type, expenseIndex, newEntry, expenseList);
    }

    /**
     * Edits a specific index in the list
     *
     * @param type entry type of the expense to be changed
     * @param expenseIndex index of the expense in the list
     * @param newEntry new entry that will replace current entry
     */
    public static void editExpense(String type, int expenseIndex, String newEntry) {
        editEntry(type, expenseIndex, newEntry, expenseList);
        SaveExpense.writeFile(expenseList);
    }


    /**
     * Sorts expenses using Entry comparator
     */
    private static void sortExpensesByAmount() {
        sortEntriesByAmount(expenseList);
    }
    private static void sortExpensesByDate() {
        sortEntriesByDate(expenseList);
    }


}
