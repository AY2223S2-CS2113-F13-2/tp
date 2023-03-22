package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.ExpenseList;

public class SortExpenseByDateCommand extends Command {
    public static final String COMMAND_WORD = "sortExpenseByDate";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": shows the expenses made, sorted by date of expense\n"
            + "|  Example: " + COMMAND_WORD;

    public void execute() {
        ExpenseList.sortExpensesByDate();
    }
}
