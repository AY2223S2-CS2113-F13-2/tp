package seedu.brokeMan.command;

import seedu.brokeMan.entry.income.IncomeList;
import seedu.brokeMan.parser.StringToTime;
import seedu.brokeMan.ui.Ui;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_EDIT_COMMAND;
import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_TIME;

public class EditIncomeCommand extends Command {
    public static final String COMMAND_WORD = "editIncome";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": edit the income from the list.\n" +
            "|  Parameter: i/ <index> t/ <type> n/ <newEntry>\n" +
            "|  There are 3 type that can be changed, income, info, time\n" +
            "|  Example: " + COMMAND_WORD + " i/ 1 t/ info n/ stocks";
    private int index;
    private String type;
    private String newEntry;

    public EditIncomeCommand(int index, String type, String newEntry) {
        this.index = index;
        this.type = type;
        this.newEntry = newEntry;
    }

    public void execute() {
        try {
            switch (type) {
            case "income":
                Double newCost = Double.parseDouble(newEntry);
                IncomeList.editIncome(index, newCost);
                break;
            case "info":
                IncomeList.editIncome(index, newEntry);
                break;
            case "time":
                LocalDateTime newTime = StringToTime.convertStringToTime(newEntry);
                IncomeList.editIncome(index, newTime);
                break;
            default:
                Ui.showToUserWithLineBreak(MESSAGE_INVALID_EDIT_COMMAND);

            }
        } catch (DateTimeException dte) {
            Ui.showToUserWithLineBreak(MESSAGE_INVALID_TIME, "");
        }
    }
}
