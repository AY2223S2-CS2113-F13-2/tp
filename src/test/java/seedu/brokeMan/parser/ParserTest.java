package seedu.brokeMan.parser;

import org.junit.jupiter.api.Test;
import seedu.brokeMan.command.AddExpenseCommand;
import seedu.brokeMan.command.AddIncomeCommand;
import seedu.brokeMan.command.Command;
import seedu.brokeMan.command.DeleteExpenseCommand;
import seedu.brokeMan.command.DeleteIncomeCommand;
import seedu.brokeMan.command.EditExpenseCommand;
import seedu.brokeMan.command.EditIncomeCommand;
import seedu.brokeMan.command.HelpCommand;
import seedu.brokeMan.command.InvalidCommand;
import seedu.brokeMan.command.ListExpenseCommand;
import seedu.brokeMan.command.ListIncomeCommand;
import seedu.brokeMan.command.SetBudgetCommand;
import seedu.brokeMan.command.SortExpenseByAmountCommand;
import seedu.brokeMan.command.SortExpenseByDateCommand;
import seedu.brokeMan.command.SortIncomeByAmountCommand;
import seedu.brokeMan.command.SortIncomeByDateCommand;
import seedu.brokeMan.command.ViewBudgetCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
    @Test
    void validViewBudgetShouldReturnViewBudgetCommand() {
        final String userFirstInput = "setBudget 500";
        Command firstCommand = Parser.parseCommand(userFirstInput);
        firstCommand.execute();

        final String userSecondInput = "viewBudget";
        Command secondCommand = Parser.parseCommand(userSecondInput);

        assertTrue(secondCommand instanceof ViewBudgetCommand);
    }

    @Test
    void validSetBudgetShouldReturnSetBudgetCommand() {
        final String userFullInput = "setBudget 500";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof SetBudgetCommand);
    }

    @Test
    void randomCommandShouldReturnHelpCommand() {
        final String userFullInput = "random inputs";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof HelpCommand);
    }

    @Test
    void wrongAddIncomeCommandShouldReturnInvalidCommand() {
        final String userFullInput = "addIncome a/ d/ t/";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof InvalidCommand);
    }

    @Test
    void wrongAddExpenseCommandShouldReturnInvalidCommand() {
        final String userFullInput = "addExpense wrong arguments";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof InvalidCommand);
    }

    @Test
    void wrongDeleteExpenseCommandShouldReturnInvalidCommand() {
        final String userFullInput = "deleteExpense wrong";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof InvalidCommand);
    }

    @Test
    void wrongDeleteIncomeCommandShouldReturnInvalidCommand() {
        final String userFullInput = "deleteIncome ";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof InvalidCommand);
    }

    @Test
    void wrongEditExpenseCommandShouldReturnInvalidCommand() {
        final String userFullInput = "editExpense a/ a/ a/";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof InvalidCommand);
    }

    @Test
    void wrongEditIncomeCommandShouldReturnInvalidCommand() {
        final String userFullInput = "editIncome wrong arguments";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof InvalidCommand);
    }

    @Test
    void validAddExpenseCommandShouldReturnAddExpenseCommand() {
        final String userFullInput = "addExpense a/ 4.0 d/ lunch t/ 2022 08 12 11 59";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof AddExpenseCommand);
    }

    @Test
    void validAddIncomeCommandShouldReturnAddIncomeCommand() {
        final String userFullInput = "addIncome a/ 400 d/ stocks t/ 2023 12 11 12 41";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof AddIncomeCommand);
    }

    @Test
    void validDeleteExpenseCommandShouldReturnDeleteExpenseCommand() {
        final String userFirstInput = "addExpense a/ 4.0 d/ lunch t/ 2022 07 21 10 41";
        Command addExpenseCommand = Parser.parseCommand(userFirstInput);
        addExpenseCommand.execute();
        final String userFullInput = "deleteExpense 1";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof DeleteExpenseCommand);
    }

    @Test
    void validDeleteIncomeCommandShouldReturnDeleteIncomeCommand() {
        final String userFirstInput = "addIncome a/ 4000 d/ salary t/ 2012 04 29 01 40";
        Command addIncomeCommand = Parser.parseCommand(userFirstInput);
        addIncomeCommand.execute();
        final String userFullInput = "deleteIncome 1";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof DeleteIncomeCommand);
    }

    @Test
    void validEditExpenseCommandShouldReturnEditExpenseCommand() {
        final String userFirstInput = "addExpense a/ 4.0 d/ lunch t/ 2017 08 19 13 29";
        Command addExpenseCommand = Parser.parseCommand(userFirstInput);
        addExpenseCommand.execute();
        final String userFullInput = "editExpense i/ 1 t/ info n/ brunch";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof EditExpenseCommand);
    }

    @Test
    void validEditIncomeCommandShouldReturnEditIncomeCommand() {
        final String userFirstInput = "addIncome a/ 4000 d/ salary t/ 2000 10 19 12 42";
        Command addExpenseCommand = Parser.parseCommand(userFirstInput);
        addExpenseCommand.execute();
        final String userFullInput = "editIncome i/ 1 t/ amount n/ 3000";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof EditIncomeCommand);
    }

    @Test
    void validListExpenseCommandShouldReturnListExpenseCommand() {
        final String userFullInput = "listExpense";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof ListExpenseCommand);
    }

    @Test
    void validListIncomeCommandShouldReturnListIncomeCommand() {
        final String userFullInput = "listIncome";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof ListIncomeCommand);
    }

    @Test
    void validSortExpenseByAmountCommandShouldReturnValidCommand() {
        final String userFullInput = "sortExpenseByAmount";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof SortExpenseByAmountCommand);
    }

    @Test
    void validSortIncomeByAmountCommandShouldReturnValidCommand() {
        final String userFullInput = "sortIncomeByAmount";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof SortIncomeByAmountCommand);
    }

    @Test
    void validSortExpenseByDateCommandShouldReturnValidCommand() {
        final String userFullInput = "sortExpenseByDate";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof SortExpenseByDateCommand);
    }

    @Test
    void validSortIncomeByDateCommandShouldReturnValidCommand() {
        final String userFullInput = "sortIncomeByDate";
        Command actualCommand = Parser.parseCommand(userFullInput);

        assertTrue(actualCommand instanceof SortIncomeByDateCommand);
    }
}
