package seedu.brokeMan.command;

import seedu.brokeMan.budget.Budget;
import seedu.brokeMan.exception.hasNotSetBudgetException;

public class ViewBudgetCommand extends Command {
    public static final String COMMAND_WORD = "viewBudget";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": view your budget remaining.\n" +
            "|  Example: " + COMMAND_WORD;

    public ViewBudgetCommand() throws hasNotSetBudgetException {
        if (!Budget.hasSetBudget) {
            throw new hasNotSetBudgetException();
        }
    }

    @Override
    public void execute() {
        Budget.viewBudget();
    }
}
