package seedu.brokeMan.command;


import seedu.brokeMan.entry.income.IncomeList;

public class SortIncomeByDateCommand extends Command {
    public static final String COMMAND_WORD = "sortIncomeByDate";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": shows the incomes made, sorted by date of income\n"
            + "|  Example: " + COMMAND_WORD;

    public void execute() {
        IncomeList.sortIncomeByDate();
    }
}
