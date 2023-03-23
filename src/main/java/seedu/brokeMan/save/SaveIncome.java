package seedu.brokeMan.save;

import seedu.brokeMan.entry.Entry;
import seedu.brokeMan.entry.income.Income;
import seedu.brokeMan.entry.income.IncomeList;

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


public class SaveIncome {
    /*
     * saves all incomes under any change
     */
    public static void writeFile(LinkedList<Entry> incomes) {
        try {
            FileWriter myWriter = new FileWriter("./data/IncomeData.txt");
            myWriter.flush();
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
                boolean newFile = myObj.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void readIncomeFile() {
        try {
            String filePath = "./data/IncomeData.txt";
            ArrayList<String> incomeEntries;
            incomeEntries = (ArrayList<String>) Files.readAllLines(Paths.get(filePath),
                    StandardCharsets.UTF_8);
            for (String incomeEntry : incomeEntries) {
                String[] strIncome = incomeEntry.split("/");
                try {
                    Income income = new Income(Double.parseDouble(strIncome[0]),
                            strIncome[1],
                            LocalDateTime.parse(strIncome[2]));
                    IncomeList.addIncome(income);
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("Incorrectly Saved Income");
                }
            }
        } catch (IOException ioe) {
            try {
                Files.createDirectories(Path.of("./data"));
                File myObj = new File("./data/IncomeData.txt");
                boolean newFile = myObj.createNewFile();
            } catch (IOException fcIoe) {
                ioe.printStackTrace();
            }
        }
    }
}
