package seedu.brokeMan.entry.income;

import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.EntryList;
import seedu.brokeMan.save.SaveIncome;
import seedu.brokeMan.ui.Ui;

import java.time.LocalDateTime;
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
     * @param index index of the expense in the list
     * @param newEntry new entry that will replace current entry
     */
    public static void editIncome(int index, String newEntry) {
        editEntryDescription(index, newEntry, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    public static void editIncome(int index, Double newEntry) {
        editEntryCost(index, newEntry, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    public static void editIncome(int index, LocalDateTime newEntry) {
        editEntryTime(index, newEntry, incomeList);
        SaveIncome.writeFile(incomeList);
    }


    /**
     * Sorts income using Entry comparator
     */
    public static void sortIncomeByAmount() {
        sortEntriesByAmount(incomeList);
    }
    public static void sortIncomeByDate() {
        sortEntriesByDate(incomeList);
    }

}
