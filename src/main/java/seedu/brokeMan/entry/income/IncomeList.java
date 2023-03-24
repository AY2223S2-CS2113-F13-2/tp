package seedu.brokeMan.entry.income;


import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.EntryList;
import seedu.brokeMan.parser.StringToTime;
import seedu.brokeMan.save.SaveIncome;
import seedu.brokeMan.ui.Ui;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class IncomeList extends EntryList {
    private static final LinkedList<Entry> incomeList = new LinkedList<>();

    /**
     * Adds new income to the list.
     *
     * @param newIncome the new income to be added
     */
    public static void addIncome(Income newIncome) {
        addEntry(newIncome, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    /**
     * delete specific income in the list
     *
     * @param index index of the income in the list
     */
    public static void deleteIncome(int index) {
        deleteEntry(index, incomeList);
        SaveIncome.writeFile(incomeList);
    }

    /**
     * list out income in the list
     */
    public static void listIncome(Optional<String> date) {
        int year = StringToTime.createYearFromString(date);
        Month month = StringToTime.createMonthFromString(date);

        List<Entry> incomeOfDate = getIncomesMadeInMonth(year, month);
        String dateInString = StringToTime.createDateString(year, month);

        Ui.showToUser("Here are the income you have made for " + dateInString + ".");
        listEntry(incomeOfDate);
        Ui.showToUser("Total income: $" + getEntryListSum(incomeOfDate));
        Ui.showToUserWithLineBreak("");
    }

    public static void listIncome() {
        Ui.showToUser("Here are the income you have made.");
        listEntry(incomeList);
        Ui.showToUser(String.format("Total income: $%.2f", getEntryListSum(incomeList)));
        Ui.showToUserWithLineBreak("");
    }

    /**
     * Edits a specific income entry in the list
     *
     * @param index    index of the expense in the list
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
        Ui.showToUser(String.format("Total income: $%.2f", getEntryListSum(incomeList)));
        Ui.showToUserWithLineBreak("");
        SaveIncome.writeFile(incomeList);
    }

    public static void sortIncomeByDate() {
        sortEntriesByDate(incomeList);
        Ui.showToUser(String.format("Total income: $%.2f", getEntryListSum(incomeList)));
        Ui.showToUserWithLineBreak("");
        SaveIncome.writeFile(incomeList);
    }

    public static List<Entry> getIncomesMadeInMonth(int year, Month month) {
        return selectEntryForDate(year, month, incomeList);
    }
}
