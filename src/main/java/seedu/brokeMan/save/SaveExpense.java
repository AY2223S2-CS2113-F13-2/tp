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
     * saves all expenses under any change
     */
    public static void writeFile(LinkedList<Entry> expenses) {
        try {
            FileWriter myWriter = new FileWriter("./data/ExpenseData.txt");
            myWriter.flush();
            String message = "";
            for (Entry expense : expenses) {
                message = expense.getAmount() +
                        "/" + expense.getInfo() +
                        "/" + expense.getTime() +
                        "\n";
                myWriter.write(message);
            }

            myWriter.close();
        } catch (IOException foe) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/ExpenseData.txt");
                boolean newFile = myObj.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void readExpenseFile() {
        try {
            String filePath = "./data/ExpenseData.txt";
            ArrayList<String> expenseEntries;
            expenseEntries = (ArrayList<String>) Files.readAllLines(Paths.get(filePath),
                    StandardCharsets.UTF_8);
            for (String expenseEntry : expenseEntries) {
                String[] strExpense = expenseEntry.split("/");
                try {
                    Expense expense = new Expense(Double.parseDouble(strExpense[0]),
                            strExpense[1],
                            LocalDateTime.parse(strExpense[2]));
                    ExpenseList.expenseList.add(expense);
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("Incorrectly Saved Expense");
                }
            }
        } catch (IOException ioe) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/ExpenseData.txt");
                boolean newFile = myObj.createNewFile();
            } catch (IOException fcIoe) {
                ioe.printStackTrace();
            }
        }
    }


}

