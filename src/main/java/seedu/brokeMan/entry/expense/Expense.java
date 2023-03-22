package seedu.brokeMan.entry.expense;

import seedu.brokeMan.entry.Entry;

import java.time.LocalDateTime;

public class Expense extends Entry {
    public Expense(double amount, String info, LocalDateTime time) {
        super(amount, info, time);
    }

    @Override
    public String toString() {
        return String.format("$%.2f spent on %s - %s", amount, info, super.convertTimeToString());
    }
}
