package seedu.brokeMan.command;

import seedu.brokeMan.budget.Budget;
import seedu.brokeMan.exception.hasNotSetBudgetException;

import java.util.Optional;

public class ViewBudgetCommand extends Command {
    public static final String COMMAND_WORD = "viewBudget";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": view your budget " +
            "and how much of it is left remaining.\n" +
            "|  " + COMMAND_WORD + " [t/ YYYY/MM]: view your budget and how much of was left in the specified month\n" +
            "|  Example: " + COMMAND_WORD + "\n" +
            "|  Example: " + COMMAND_WORD + " /t 2023/03";

    private final Optional<String> date;

    public ViewBudgetCommand(String date) {
        this.date = Optional.of(date);
    }

    public ViewBudgetCommand() throws hasNotSetBudgetException {
        if (!Budget.hasSetBudgetThisMonth()) {
            throw new hasNotSetBudgetException();
        }
        this.date = Optional.empty();
    }

    @Override
    public void execute() {
        Budget.viewBudget(date);
    }
}
