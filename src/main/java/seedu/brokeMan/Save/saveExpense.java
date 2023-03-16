package seedu.brokeMan.Save;

import seedu.brokeMan.entry.Entry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class saveExpense {
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
        } catch (IOException FileNotFoundException) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/ExpenseData.txt");

                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println("An error occurred.");
        }
    }
}
