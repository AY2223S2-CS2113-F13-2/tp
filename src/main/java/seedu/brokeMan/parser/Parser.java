package seedu.brokeMan.parser;

import seedu.brokeMan.command.AddExpenseCommand;
import seedu.brokeMan.command.AddIncomeCommand;
import seedu.brokeMan.command.Command;
import seedu.brokeMan.command.DeleteExpenseCommand;
import seedu.brokeMan.command.DeleteIncomeCommand;
import seedu.brokeMan.command.EditExpenseCommand;
import seedu.brokeMan.command.EditIncomeCommand;
import seedu.brokeMan.command.ExitCommand;
import seedu.brokeMan.command.HelpCommand;
import seedu.brokeMan.command.InvalidCommand;
import seedu.brokeMan.command.ListExpenseCommand;
import seedu.brokeMan.command.ListIncomeCommand;
import seedu.brokeMan.command.SetBudgetCommand;
import seedu.brokeMan.command.ViewBudgetCommand;
import seedu.brokeMan.command.SortIncomeByAmountCommand;
import seedu.brokeMan.command.SortExpenseByDateCommand;
import seedu.brokeMan.command.SortIncomeByDateCommand;
import seedu.brokeMan.command.SortExpenseByAmountCommand;
import seedu.brokeMan.exception.AmountIsNotADoubleException;
import seedu.brokeMan.exception.BudgetNotADoubleException;
import seedu.brokeMan.exception.IndexNotAnIntegerException;
import seedu.brokeMan.exception.NegativeBudgetException;
import seedu.brokeMan.exception.hasNotSetBudgetException;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_TIME;
import static seedu.brokeMan.common.Messages.MESSAGE_INDEX_NOT_SPECIFIED_EXCEPTION;
import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_ADD_COMMAND;
import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_EDIT_COMMAND;


/*
Some parts of the code are copied and adapted from TextUI.java of addressbook-level2
with the link to the original code at:
https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/parser/Parser.java
 */
public class Parser {

    public static Command parseCommand(String userFullInput) {
        if (!userFullInput.contains(" ")) {
            userFullInput = userFullInput.concat(" dummy");
        }
        String[] userSplitInputs = userFullInput.split(" ", 2);
        String userCommand = userSplitInputs[0];
        String description = userSplitInputs[1];

        switch(userCommand) {
        case AddExpenseCommand.COMMAND_WORD:
            return prepareAddCommand(description, "expense");
        case AddIncomeCommand.COMMAND_WORD:
            return prepareAddCommand(description, "income");
        case ListExpenseCommand.COMMAND_WORD:
            return prepareListCommand("expense");
        case ListIncomeCommand.COMMAND_WORD:
            return prepareListCommand("income");
        case EditExpenseCommand.COMMAND_WORD:
            return prepareEditCommand(description, "expense");
        case EditIncomeCommand.COMMAND_WORD:
            return prepareEditCommand(description, "income");
        case DeleteExpenseCommand.COMMAND_WORD:
            return prepareDeleteCommand(description, "expense");
        case DeleteIncomeCommand.COMMAND_WORD:
            return prepareDeleteCommand(description, "income");
        case SetBudgetCommand.COMMAND_WORD:
            return prepareSetBudgetCommand(description);
        case ViewBudgetCommand.COMMAND_WORD:
            return prepareViewBudgetCommand();
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        case SortExpenseByAmountCommand.COMMAND_WORD:
            return new SortExpenseByAmountCommand();
        case SortExpenseByDateCommand.COMMAND_WORD:
            return new SortExpenseByDateCommand();
        case SortIncomeByAmountCommand.COMMAND_WORD:
            return new SortIncomeByAmountCommand();
        case SortIncomeByDateCommand.COMMAND_WORD:
            return new SortIncomeByDateCommand();
        case HelpCommand.COMMAND_WORD: // fall through
        default:
            return new HelpCommand();
        }
    }

    private static Command prepareViewBudgetCommand() {
        try {
            return new ViewBudgetCommand();
        } catch (hasNotSetBudgetException e) {
            return new InvalidCommand(e.getMessage(), SetBudgetCommand.MESSAGE_USAGE);
        }
    }

    private static Command prepareSetBudgetCommand(String description) {
        if (description.equals("dummy")) {
            return new InvalidCommand("You did not specify your budget.",
                    SetBudgetCommand.MESSAGE_USAGE);
        }

        double budget;
        try {
            budget = Double.parseDouble(description);
            if (budget < 0) {
                String errorMessage = new NegativeBudgetException().getMessage();
                return new InvalidCommand(errorMessage, SetBudgetCommand.MESSAGE_USAGE);
            }
        } catch (NumberFormatException nfe) {
            String errorMessage = new BudgetNotADoubleException().getMessage();
            return new InvalidCommand(errorMessage, SetBudgetCommand.MESSAGE_USAGE);
        }

        return new SetBudgetCommand(budget);
    }

    private static Command prepareDeleteCommand(String description, String type) {
        int index;
        try {
            if (description.equals("dummy")) {
                if (type.equals("expense")) {
                    return new InvalidCommand(MESSAGE_INDEX_NOT_SPECIFIED_EXCEPTION,
                            DeleteExpenseCommand.MESSAGE_USAGE);
                }
                return new InvalidCommand(MESSAGE_INDEX_NOT_SPECIFIED_EXCEPTION,
                        DeleteIncomeCommand.MESSAGE_USAGE);
            }

            assert !description.equals("dummy") : MESSAGE_INDEX_NOT_SPECIFIED_EXCEPTION;
            index = Integer.parseInt(description);
        } catch (NumberFormatException nfe) {
            String errorMessage = new IndexNotAnIntegerException().getMessage();
            return new InvalidCommand(errorMessage);
        }

        if (type.equals("expense")) {
            return new DeleteExpenseCommand(index);
        }
        return new DeleteIncomeCommand(index);
    }

    private static Command prepareAddCommand(String description, String type) {
        // description in the form of "a/ <amount> d/ <description> t/ time"

        if (!description.contains("a/ ") || !description.contains(" d/ ") ||
                !description.contains(" t/ ")) {
            if (type.equals("expense")) {
                return new InvalidCommand(MESSAGE_INVALID_ADD_COMMAND, AddExpenseCommand.MESSAGE_USAGE);
            }
            return new InvalidCommand(MESSAGE_INVALID_ADD_COMMAND, AddIncomeCommand.MESSAGE_USAGE);
        }

        String[] splitDescriptions = description.split("/ ");
        double amount;
        LocalDateTime time;

        // handle error for the input "addExpense a/ d/ t/ time"
        // similarly for prepareEditExpenseCommand
        try {
            int length = splitDescriptions[1].length();
            amount = Double.parseDouble(splitDescriptions[1].substring(0, length - 2));
            time = StringToTime.convertStringToTime(splitDescriptions[3]);
        } catch (NumberFormatException nfe) {
            String errorMessage = new AmountIsNotADoubleException().getMessage();
            return new InvalidCommand(errorMessage);
        } catch (DateTimeException dte) {
            return new InvalidCommand(MESSAGE_INVALID_TIME);
        }

        String newDescription = splitDescriptions[2].substring(0, splitDescriptions[2].length() - 2);

        if (type.equals("expense")) {
            return new AddExpenseCommand(amount, newDescription, time);
        }
        assert type.equals("income") : "Type should be income";
        return new AddIncomeCommand(amount, newDescription, time);
    }

    private static Command prepareListCommand(String type) {
        if (type.equals("expense")) {
            return new ListExpenseCommand();
        }
        return new ListIncomeCommand();
    }

    private static Command prepareEditCommand(String description, String moneyType) {
        if (!description.contains("i/ ") || !description.contains(" t/ ") || !description.contains(" n/ ")) {
            if (moneyType.equals("expense")) {
                return new InvalidCommand(MESSAGE_INVALID_EDIT_COMMAND, EditExpenseCommand.MESSAGE_USAGE);
            }
            return new InvalidCommand(MESSAGE_INVALID_EDIT_COMMAND, EditIncomeCommand.MESSAGE_USAGE);
        }

        String[] splitDescriptions = description.split("/ ");

        assert splitDescriptions.length == 4 : MESSAGE_INVALID_EDIT_COMMAND;
        int index;
        String type;
        String newEntry;

        try {
            int length = splitDescriptions[1].length();
            index = Integer.parseInt(splitDescriptions[1].substring(0, length - 2));
            type = splitDescriptions[2].substring(0, splitDescriptions[2].length() - 2);
            newEntry = splitDescriptions[3];

            if (moneyType.equals("expense")) {
                return new EditExpenseCommand(index, type, newEntry);
            }
            return new EditIncomeCommand(index, type, newEntry);

        } catch (NumberFormatException nfe) {
            String errorMessage = new IndexNotAnIntegerException().getMessage();
            return new InvalidCommand(errorMessage);
        } catch (DateTimeException dte) {
            return new InvalidCommand(MESSAGE_INVALID_TIME);
        }
    }

}


