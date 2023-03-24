package seedu.brokeMan.entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.brokeMan.entry.expense.Expense;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.brokeMan.entry.EntryList.deleteEntry;
import static seedu.brokeMan.entry.EntryList.getEntryListSum;
import static seedu.brokeMan.parser.StringToTime.convertStringToTime;


public class EntryListTest {

    Entry entry1;
    Entry entry2;
    LinkedList<Entry> expenseList;

    @BeforeEach
    public void setUp() throws Exception {
        entry1 = new Expense(4, "lunch", convertStringToTime("2022 09 08 12 14"));
        entry2 = new Expense(6, "dinner",  convertStringToTime("2023 12 12 20 01"));
        expenseList = new LinkedList<Entry>(Arrays.asList(entry1, entry2));
    }


    @Test
    public void deleteEntry_inBoundIndex_success() {
        deleteEntry(2, expenseList);
        assertEquals(expenseList, new LinkedList<>(Arrays.asList(entry1)));
    }

    @Test
    public void deleteEntry_outBoundIndex_exceptionThrown() {
        try {
            deleteEntry(3, expenseList);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertThrows(IndexOutOfBoundsException.class, () -> deleteEntry(3,expenseList));
        }

    }

    @Test
    public void getTotalAmount_inputList_success() {
        assertEquals(10, getEntryListSum(expenseList));
    }


}
