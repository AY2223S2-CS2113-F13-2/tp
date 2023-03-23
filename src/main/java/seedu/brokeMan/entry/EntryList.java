package seedu.brokeMan.entry;

import seedu.brokeMan.ui.Ui;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntryList {

    /**
     * Adds new expense/income to the list
     *
     * @param newEntry new entry to be added
     */
    public static void addEntry(Entry newEntry, LinkedList<Entry> entryList) {
        entryList.add(newEntry);
        Ui.showToUserWithLineBreak("You have successfully added [" + newEntry + "]", "");
    }

    /**
     * Lists the entries in the entryList
     *
     * @param entryList LinkedList that contains the entries
     */
    public static void listEntry(List<Entry> entryList) {
        int counter = 1;
        for (Entry entryLog : entryList) {
            String message = String.format("%d. %s", counter, entryLog.toString());
            Ui.showToUser(message);
            counter++;
        }
    }


    /**
     * deletes specific entry in the list
     *
     * @param entryIndex Index of the entry in the list
     * @param entryList LinkedList that contains the entries
     *
     */
    public static void deleteEntry(int entryIndex, LinkedList<Entry> entryList) {
        try {
            entryList.remove(entryIndex - 1);
            Ui.showToUserWithLineBreak("Successfully deleted expense.", "");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            Ui.showToUserWithLineBreak("Invalid index! Please try again.", "");
        }
    }

    /**
     * Edits amount of money for an entry in the specific index in the list
     *
     * @param entryIndex index of the entry in the list
     * @param newAmount new entry that will replace current entry
     * @param entryList LinkedList that contains the entries
     *
     */
    public static void editEntryCost(int entryIndex, double newAmount, LinkedList<Entry> entryList) {
        try {
            Entry entryBeingEdited = entryList.get(entryIndex - 1);
            entryBeingEdited.editAmount(newAmount);
            Ui.showToUserWithLineBreak("Successfully edited expense.", "");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            Ui.showToUserWithLineBreak("Invalid index! Please try again.", "");
        }
    }

    /**
     * Edits description of an entry in the specific index in the list
     *
     * @param entryIndex index of the entry in the list
     * @param newDescription new description that will replace current description
     * @param entryList LinkedList that contains the entries
     *
     */
    public static void editEntryDescription(int entryIndex, String newDescription, LinkedList<Entry> entryList) {
        try {
            Entry entryBeingEdited = entryList.get(entryIndex - 1);
            entryBeingEdited.editDescription(newDescription);
            Ui.showToUserWithLineBreak("Successfully edited expense.", "");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            Ui.showToUserWithLineBreak("Invalid index! Please try again.", "");
        }
    }

    /**
     * Edits time of an entry in the specific index in the list
     *
     * @param entryIndex index of the entry in the list
     * @param newTime new time that will replace current time
     * @param entryList LinkedList that contains the entries
     *
     */
    public static void editEntryTime(int entryIndex, LocalDateTime newTime, LinkedList<Entry> entryList) {
        try {
            Entry entryBeingEdited = entryList.get(entryIndex - 1);
            entryBeingEdited.editTime(newTime);
            Ui.showToUserWithLineBreak("Successfully edited expense.", "");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            Ui.showToUserWithLineBreak("Invalid index! Please try again.", "");
        }
    }

    protected static double getTotalAmount(LinkedList<Entry> entryList) {
        double totalAmount = 0;
        if (entryList.size() > 0) {
            for (Entry entryLog : entryList) {
                totalAmount += entryLog.getAmount();
            }
        }
        return totalAmount;
    }

    /**
     * Sorts entries using Entry comparator
     * @param entryList LinkedList that contains the entries
     *
     */
    protected static void sortEntriesByAmount(LinkedList<Entry> entryList) {
        entryList.sort(new EntryAmountComparator());
        listEntry(entryList);
    }

    protected static void sortEntriesByDate(LinkedList<Entry> entryList) {
        entryList.sort(new EntryDateComparator());
        listEntry(entryList);
    }

    protected static List<Entry> selectEntryForDate(int year, Month month, LinkedList<Entry> entryList) {
        return entryList.stream().filter(x -> x.isSameMonth(year, month)).collect(Collectors.toList());
    }

    public static double getEntryListSum(List<Entry> entryList) {
        double sum = 0;
        for (Entry entry : entryList) {
            sum += entry.getAmount();
        }
        return sum;
    }
}
