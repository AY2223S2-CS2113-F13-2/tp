package seedu.brokeMan.entry.income;

import seedu.brokeMan.entry.Entry;

import java.time.LocalDateTime;

public class Income extends Entry {
    public Income(double amount, String info, LocalDateTime time) {
        super(amount, info, time);
    }

    public String toString() {
        return String.format("$%.2f earned on %s - %s", amount, info, super.convertTimeToString());
    }
}
