package seedu.brokeMan.entry;

import java.util.Comparator;

public class EntryDateComparator implements Comparator<Entry> {
    public int compare(Entry e1, Entry e2) {
        return (int)((e2.getAmount() - e1.getAmount()) * 100);} //not yet implemented
}