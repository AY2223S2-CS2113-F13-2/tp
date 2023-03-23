package seedu.brokeMan.command;

import seedu.brokeMan.budget.Budget;

import java.util.Optional;

public class SetBudgetCommand extends Command {
    public static final String COMMAND_WORD = "setBudget";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": sets your budget.\n" +
            "|  Parameter: <amount> [d/ YYYY/MM]\n" +
            "|  Example: " + COMMAND_WORD + " 500\n" +
            "|  Example: " + COMMAND_WORD + " 500 2023/03";
    private final double budget;
    private final Optional<String> date;

    public SetBudgetCommand(double budget) {
        this.budget = budget;
        date = Optional.empty();
    }

    public SetBudgetCommand(double budget, String date) {
        this.budget = budget;
        this.date = Optional.of(date);
    }

    public void execute() {
        Budget.setBudget(budget, this.date);
    }
}
