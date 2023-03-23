package seedu.brokeMan.entry;

import java.time.LocalDateTime;

public abstract class Entry {
    protected String info;
    protected double amount;
    protected LocalDateTime time;
    protected Category category;

    public Entry(double amount, String info, LocalDateTime time, Category category) {
        this.amount = amount;
        this.info = info;
        this.time = time;
        this.category = category;
    }

    /**
     * Edits amount of the expense/income
     *
     * @param newAmount New desired amount of the expense/income
     */
    public void editAmount(double newAmount) {
        this.amount = newAmount;
    }

    /**
     * Edits information entry of the expense/income
     *
     * @param newInfo New desired information of the expense/income
     */
    public void editDescription(String newInfo) {
        this.info = newInfo;
    }

    /**
     * Edits time entry of the expense/income
     *
     * @param newTime New desired time of the expense/income
     */
    public void editTime(LocalDateTime newTime) {
        this.time = newTime;
    }

    public void editCategory(Category newCategory) {this.category = newCategory; }

    public double getAmount() {
        return this.amount;
    }

    public String getTime() { return this.time.toString(); }

    public Category getCategory() { return this.category; }

    protected String convertTimeToString() {
        String timeAsString = this.time.toString();
        int indexOfT = timeAsString.indexOf('T');
        String dateString = timeAsString.substring(0, indexOfT);
        String timeString = timeAsString.substring(indexOfT + 1);
        return String.format("%s @ %s", dateString, timeString);
    }
    public abstract String toString();
}
