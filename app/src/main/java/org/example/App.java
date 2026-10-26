package org.example;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        CheeseReader reader = new CheeseReader();
        ArrayList<String> lines = reader.readLines("cheese_data.csv");

        if (lines.size() == 0) {
            System.out.println("No data was read. Check the file name and location.");
            return;
        }

        CheeseRowCleaner cleaner = new CheeseRowCleaner();
        CheeseParser parser = new CheeseParser(lines.get(0), cleaner);
        CheeseList cheeseList = new CheeseList();
        for (int i = 1; i < lines.size(); i++) {
            Cheese cheese = parser.parseLine(lines.get(i));
            if (cheese != null) {
                cheeseList.add(cheese);
            }
        }

        CheeseAnalyzer analyzer = new CheeseAnalyzer(cheeseList);

        CheeseWriter writer = new CheeseWriter();
        writer.writeResults("output.txt", analyzer);

        System.out.println("Read " + cheeseList.size() + " cheeses. Results saved to output.txt");
    }
}
