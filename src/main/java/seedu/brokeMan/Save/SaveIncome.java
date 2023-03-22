package seedu.brokeMan.Save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;

import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.expense.Expense;
import seedu.brokeMan.entry.expense.Expenses;

/*
Saves all incomes under any change
 */
public class SaveIncome {

    public static void writeFile(LinkedList<Entry> incomes) {
        try {
            FileWriter myWriter = new FileWriter("./data/IncomeData.txt");
            myWriter.flush();
            String strTask = "";
            String message = "";
            for (Entry incomeLog : incomes) {
                message = incomeLog.getAmount() + "/" + incomeLog.getInfo() + "/" + incomeLog.getTime();
            }
            myWriter.write(message);
            myWriter.close();
        } catch (IOException FileNotFoundException) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/IncomeData.txt");
                boolean fileCreated = false;
                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());
                    fileCreated = true;
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    public static void readIncomeFile() {
        try {
            String filePath = "./data/IncomeData.txt";
            ArrayList<String> incomeEntries = new ArrayList<>();
            incomeEntries = (ArrayList<String>) Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (String incomeEntry : incomeEntries) {
                String[] strIncome = incomeEntry.split("/");
                try {
                    Expense expense = new Expense(Double.parseDouble(strIncome[0]), strIncome[1], strIncome[2]);
                    Expenses.addExpense(expense);
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("Incorrectly Saved Income");
                }
            }
        } catch (IOException ioe) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/IncomeData.txt");
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
