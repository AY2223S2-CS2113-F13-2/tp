package seedu.brokeMan.entry;

import java.time.LocalDateTime;
import java.time.Month;

public abstract class Entry {
    protected String info;
    protected double amount;
    protected LocalDateTime time;

    public Entry(double amount, String info, LocalDateTime time) {
        this.amount = amount;
        this.info = info;
        this.time = time;
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
    public String getInfo() {
        return this.info;
    }
    public double getAmount() {
        return this.amount;
    }

    public String getTime() { return this.time.toString(); }
    public String getInfo() {
        return this.info;
    }
    protected String convertTimeToString() {
        String timeAsString = this.time.toString();
        int indexOfT = timeAsString.indexOf('T');
        String dateString = timeAsString.substring(0, indexOfT);
        String timeString = timeAsString.substring(indexOfT + 1);
        return String.format("%s @ %s", dateString, timeString);
    }

    protected boolean isSameMonth(int year, Month month) {
        return (this.time.getYear() == year && this.time.getMonth().equals(month));
    }

    public abstract String toString();


}
