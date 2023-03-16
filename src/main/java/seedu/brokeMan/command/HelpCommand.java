package seedu.brokeMan.command;

import seedu.brokeMan.ui.Ui;

public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": shows all the commands for the program.\n" +
            "|  Example: " + COMMAND_WORD;
    public void execute() {
        Ui.showToUserWithLineBreak(AddExpenseCommand.MESSAGE_USAGE, "",
                AddIncomeCommand.MESSAGE_USAGE, "", DeleteExpenseCommand.MESSAGE_USAGE, "",
                DeleteIncomeCommand.MESSAGE_USAGE, "",EditExpenseCommand.MESSAGE_USAGE, "",
                EditIncomeCommand.MESSAGE_USAGE, "", ListExpenseCommand.MESSAGE_USAGE, "",
                ListIncomeCommand.MESSAGE_USAGE, "",HelpCommand.MESSAGE_USAGE, "");
    }
}