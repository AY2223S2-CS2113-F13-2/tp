package seedu.brokeMan.command;

import seedu.brokeMan.entry.income.IncomeList;

import java.util.Optional;

public class ListIncomeCommand extends Command {
    public static final String COMMAND_WORD = "listIncome";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": lists incomes made in the current month.\n" +
            "|  " + COMMAND_WORD + " [t/ YYYY/MM]: : lists incomes made in the specified month\n" +
            "|  Example: " + COMMAND_WORD + "\n" +
            "|  Example: " + COMMAND_WORD + " t/ 2023/03";

    private final Optional<String> date;

    public ListIncomeCommand() {
        this.date = Optional.empty();
    }

    public ListIncomeCommand(String date) {
        this.date = Optional.of(date);
    }

    public void execute() {
        if (date.isEmpty()) {
            IncomeList.listIncome();
        } else if (date.isPresent()) {
            IncomeList.listIncome(date);
        }
    }
}
