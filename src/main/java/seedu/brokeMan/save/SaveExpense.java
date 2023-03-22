package seedu.brokeMan.save;

import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.expense.Expense;
import seedu.brokeMan.entry.expense.ExpenseList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class SaveExpense {
    /*
Saves all expenses under any change
 */
    public static void writeFile(LinkedList<Entry> expenses) {
        try {
            FileWriter myWriter = new FileWriter("./data/ExpenseData.txt");
            myWriter.flush();
            String strTask = "";

            String message = "";
            for (Entry expense : expenses) {
                message = expense.getAmount() + "/" + expense.getInfo() + "/" + expense.getTime();
            }
            myWriter.write(message);

            myWriter.close();
        } catch (IOException foe) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/ExpenseData.txt");

                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void readExpenseFile() {
        try {
            String filePath = "./data/ExpenseData.txt";
            ArrayList<String> expenseEntries = new ArrayList<>();
            expenseEntries = (ArrayList<String>) Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (String expenseEntry : expenseEntries) {
                String[] strExpense = expenseEntry.split("/");
                try {
                    Expense expense = new Expense(Double.parseDouble(strExpense[0]), strExpense[1], LocalDateTime.parse(strExpense[2]));
                    ExpenseList.addExpense(expense);
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("Incorrectly Saved Expense");
                }
            }
        } catch (IOException ioe) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/ExpenseData.txt");
                boolean fileCreated = false;
                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());
                    fileCreated = true;
                }
            } catch (IOException fcIoe) {
                ioe.printStackTrace();
            }
        }
    }


}

