package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.Expenses;

public class ListExpenseCommand extends Command {
    public static final String COMMAND_WORD = "listExpense";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": lists the expense you have made.\n" +
            "|  Example: " + COMMAND_WORD;

    public void execute() {
        Expenses.listExpense();
    }
}
