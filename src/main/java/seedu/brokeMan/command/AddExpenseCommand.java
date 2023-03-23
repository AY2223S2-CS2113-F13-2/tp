package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.Expense;
import seedu.brokeMan.entry.expense.ExpenseList;

import java.time.LocalDateTime;

public class AddExpenseCommand extends Command {
    public static final String COMMAND_WORD = "addExpense";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": add expense to the expense list.\n" +
            "|  Parameters: a/ <amount> d/ <description> t/ <time>\n" +
            "|  Example: " + COMMAND_WORD + " a/ 4.5 d/ lunch t/ 2023 3 22 20 12";
    private final Expense expense;

    public AddExpenseCommand(double cost, String info, LocalDateTime time) {

        this.expense = new Expense(cost, info, time);
    }

    public void execute() {
        ExpenseList.addExpense(expense);
    }
}
