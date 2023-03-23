package seedu.brokeMan;

import seedu.brokeMan.Save.SaveExpense;
import seedu.brokeMan.Save.SaveIncome;
import seedu.brokeMan.command.Command;
import seedu.brokeMan.command.ExitCommand;
import seedu.brokeMan.parser.Parser;
import seedu.brokeMan.save.SaveExpense;
import seedu.brokeMan.save.SaveIncome;
import seedu.brokeMan.ui.Ui;

public class BrokeMan {

    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void main(String[] args) {
        new BrokeMan().run();
    }

    public static void run() {
        Ui.showWelcomeMessages();
        runCommandUntilExitCommand();
        Ui.showGoodByeMessages();
    }

    public static void runCommandUntilExitCommand() {
        Command command;
        SaveExpense.readExpenseFile();
        SaveIncome.readIncomeFile();
        do {
            String userFullInput = Ui.getUserCommand();
            command = Parser.parseCommand(userFullInput);
            command.execute();
        } while (!ExitCommand.isExit(command));
    }
}
