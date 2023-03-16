package seedu.brokeMan.Save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

import seedu.brokeMan.entry.Entry;

/*
Saves all incomes under any change
 */
public class saveIncome {

    public static void writeFile(LinkedList<Entry> incomes) {
        try {
            FileWriter myWriter = new FileWriter("./data/IncomeData.txt");
            myWriter.flush();
            String strTask = "";

            int counter = 1;
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
