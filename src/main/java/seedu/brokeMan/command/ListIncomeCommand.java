package seedu.brokeMan.command;

import seedu.brokeMan.entry.income.IncomeList;

public class ListIncomeCommand extends Command {
    public static final String COMMAND_WORD = "listIncome";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": lists the income you have made.\n" +
            "|  Example: " + COMMAND_WORD;

    public void execute() {
        IncomeList.listIncome();
    }
}
