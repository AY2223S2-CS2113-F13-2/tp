package seedu.brokeMan.budget;

import seedu.brokeMan.ui.Ui;

import static seedu.brokeMan.entry.expense.Expenses.getTotalExpense;

public class Budget {
    public static boolean hasSetBudget = false;
    private static double budget;

    public static void viewBudget() {
        double totalExpenses = getTotalExpense();
        double budgetLeft = budget - totalExpenses;

        Ui.showToUser("You have set your budget as $" + budget);
        if (budgetLeft >= 0) {
            Ui.showToUserWithLineBreak("The amount of budget left is $" + budgetLeft, "");
        } else {
            Ui.showToUserWithLineBreak("You have overspent your expenses by $" + budgetLeft, "");
        }
    }

    public static void setBudget(double budget) {
        hasSetBudget = true;
        Budget.budget = budget;
        Ui.showToUserWithLineBreak("You have successfully set " + budget + " as your budget.", "");
    }
}
