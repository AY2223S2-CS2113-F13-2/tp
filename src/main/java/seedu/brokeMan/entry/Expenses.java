package seedu.brokeMan.entry;

import java.util.LinkedList;

public class Expenses extends EntryList{
    private static final LinkedList<Expense> expenseList = new LinkedList<>();


    /**
     * Adds new expense to the list
     *
     * @param newExpense new expense to be added
     */
    public static void addExpense(Expense newExpense) {
        addEntry(newExpense);
    }

    /**
     * lists out expenses in the list
     */
    public static void listExpense() {
        listEntry();
    }

    /**
     * deletes specific expense in the list
     *
     * @param expenseIndex Index of the expense in the list
     */
    public static void deleteExpense(int expenseIndex) {
        deleteEntry(expenseIndex);
    }

    /**
     * Edits a specific index in the list
     *
     * @param type entry type of the expense to be changed
     * @param expenseIndex index of the expense in the list
     * @param newEntry new entry that will replace current entry
     */
    public static void editExpenseCost(String type, int expenseIndex, double newEntry) {
        editEntry(type, expenseIndex, newEntry);
    }

    /**
     * Edits a specific index in the list
     *
     * @param type entry type of the expense to be changed
     * @param expenseIndex index of the expense in the list
     * @param newEntry new entry that will replace current entry
     */
    public static void editExpense(String type, int expenseIndex, String newEntry) {
        editEntry(type, expenseIndex, newEntry);
    }


    /**
     * Sorts expenses using Entry comparator
     */
    private static void sortExpensesByAmount() {
        sortEntriesByAmount();
    }
    private static void sortExpensesByDate() {
        sortEntriesByDate();
    }


}
