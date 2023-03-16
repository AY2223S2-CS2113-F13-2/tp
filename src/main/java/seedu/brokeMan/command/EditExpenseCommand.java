package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.Expenses;

public class EditExpenseCommand extends Command {
    public static final String COMMAND_WORD = "editExpense";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": edit the expense from the list.\n" +
            "|  Parameter: i/ <index> t/ <type> n/ <newEntry>\n" +
            "|  There are 3 type that can be changed, cost, info, time\n" +
            "|  Example: " + COMMAND_WORD + " i/ 1 t/ cost n/ 5";
    private int index;
    private String type;
    private double newCost;
    private String newEntry;
    private boolean isEditCost = false;

    public EditExpenseCommand(int index, String type, String newEntry) {
        this.index = index;
        this.type = type;
        this.newEntry = newEntry;
    }

    public EditExpenseCommand(int index, String type, double newCost) {
        this.index = index;
        this.type = type;
        this.newCost = newCost;
        isEditCost = true;
    }

    public void execute() {
        if (isEditCost) {
            Expenses.editExpenseCost(type, index, newCost);
        } else {
            Expenses.editExpense(type, index, newEntry);
        }
    }
}
