package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.ExpenseList;

public class SortExpenseByAmountCommand extends Command {
    public static final String COMMAND_WORD = "sortExpenseByAmount";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": shows the expenses made, sorted by amount of expense\n"
            + "|  Example: " + COMMAND_WORD;

    public void execute() {
        ExpenseList.sortExpensesByAmount();
    }
}
