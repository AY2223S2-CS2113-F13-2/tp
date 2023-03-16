package seedu.brokeMan.entry.expense;

import seedu.brokeMan.entry.Entry;

public class Expense extends Entry {
    public Expense(double amount, String info, String time) {
        super(amount, info, time);
    }

    @Override
    public String toString() {
        return String.format("$%.2f spent on %s - %s", amount, info, time);
    }
}
