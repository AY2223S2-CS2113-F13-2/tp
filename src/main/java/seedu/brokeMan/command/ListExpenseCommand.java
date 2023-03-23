package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.ExpenseList;

import java.util.Optional;

public class ListExpenseCommand extends Command {
    public static final String COMMAND_WORD = "listExpense";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": lists expenses made in the current month.\n" +
            "|  " + COMMAND_WORD + " [t/ YYYY/MM]: : lists expenses made in the specified month\n" +
            "|  Example: " + COMMAND_WORD + "\n" +
            "|  Example: " + COMMAND_WORD + " t/ 2023/03";

    private final Optional<String> date;

    public ListExpenseCommand() {
        this.date = Optional.empty();
    }

    public ListExpenseCommand(String date) {
        this.date = Optional.of(date);
    }
    public void execute() {
        if (date.isEmpty()) {
            ExpenseList.listExpense();
        } else if (date.isPresent()) {
            ExpenseList.listExpense(date);
        }
    }
}
