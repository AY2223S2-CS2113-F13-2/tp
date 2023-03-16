package seedu.brokeMan.entry.income;

import seedu.brokeMan.entry.Entry;

public class Income extends Entry {
    public Income(double amount, String info, String time) {
        super(amount, info, time);
    }

    public String toString() {
        return String.format("$%.2f earned on %s - %s", amount, info, time);
    }
}
