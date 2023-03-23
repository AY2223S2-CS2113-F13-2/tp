package seedu.brokeMan.command;

import seedu.brokeMan.entry.income.IncomeList;

public class SortIncomeByAmountCommand extends Command {
    public static final String COMMAND_WORD = "sortIncomeByAmount";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": shows the incomes made, sorted by amount of income\n"
            + "|  Example: " + COMMAND_WORD;

    public void execute() {
        IncomeList.sortIncomeByAmount();
    }
}
