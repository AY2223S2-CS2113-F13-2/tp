package seedu.brokeMan.entry.income;


import seedu.brokeMan.Save.SaveIncome;
import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.EntryList;
import seedu.brokeMan.ui.Ui;

import java.util.LinkedList;

public class IncomeList extends EntryList {
    private static final LinkedList<Entry> incomeList = new LinkedList<>();

    /**
     * Adds new income to the list.
     * @param newIncome the new income to be added
     */
    public static void addIncome(Income newIncome) {
        addEntry(newIncome, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    /**
     * delete specific income in the list
     * @param index index of the income in the list
     */
    public static void deleteIncome(int index) {
        deleteEntry(index, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    /**
     * list out income in the list
     */
    public static void listIncome() {
        Ui.showToUser("Here are the income you have made.");
        listEntry(incomeList);
        Ui.showToUser("Total income: $" + getTotalAmount(incomeList));
        Ui.showToUserWithLineBreak("");
    }

    /**
     * Edits a specific income entry in the list
     * @param type entry type of the income to be changed
     * @param index index of the expense in the list
     * @param newEntry new entry that will replace current entry
     */
    public static void editIncome(String type, int index, String newEntry) {
        editEntry(type, index, newEntry, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    /**
     * Edits a specific index in the list
     * @param type entry type of the income to be changed
     * @param index index of the expense in the list
     * @param newIncome new income that will replace current entry
     */
    public static void editIncomeDouble(String type, int index, double newIncome) {
        editEntry(type, index, newIncome, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    /**
     * Sorts income using Entry comparator
     */
    private static void sortIncomeByAmount() {
        sortEntriesByAmount(incomeList);
    }
    private static void sortIncomeByDate() {
        sortEntriesByDate(incomeList);
    }

}
