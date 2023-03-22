package seedu.brokeMan.command;

import seedu.brokeMan.entry.expense.ExpenseList;
import seedu.brokeMan.parser.StringToTime;
import seedu.brokeMan.ui.Ui;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_EDIT_COMMAND;
import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_TIME;

public class EditExpenseCommand extends Command {
    public static final String COMMAND_WORD = "editExpense";
    private static final Logger logger = Logger.getLogger("EditExpenseCommandLogger");

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": edit the expense from the list.\n" +
            "|  Parameter: i/ <index> t/ <type> n/ <newEntry>\n" +
            "|  There are 3 type that can be changed, cost, info, time\n" +
            "|  Example: " + COMMAND_WORD + " i/ 1 t/ cost n/ 5";
    private final int index;
    private final String type;
    private final String newEntry;

    public EditExpenseCommand(int index, String type, String newEntry) {
        this.index = index;
        this.type = type;
        this.newEntry = newEntry;
    }

    public void execute() {
        try {
            switch (type) {
            case "cost":
                Double newCost = Double.parseDouble(newEntry);
                ExpenseList.editExpense(index, newCost);
                break;
            case "info":
                ExpenseList.editExpense(index, newEntry);
                break;
            case "time":
                LocalDateTime newTime = StringToTime.convertStringToTime(newEntry);
                ExpenseList.editExpense(index, newTime);
                break;
            default:
                logger.log(Level.WARNING, "wrong type name:" + type);
                Ui.showToUserWithLineBreak(MESSAGE_INVALID_EDIT_COMMAND);

            }
        } catch (DateTimeException dte) {
            Ui.showToUserWithLineBreak(MESSAGE_INVALID_TIME, "");
        }
    }
}
