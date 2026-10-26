package org.example;

import java.io.FileOutputStream;

public class CheeseWriter {

    public void writeResults(String fileName, CheeseAnalyzer analyzer) {
        String text = "";
        text = text + "Pasteurized milk cheeses: " + analyzer.countPasteurized() + "\n";
        text = text + "Raw milk cheeses: " + analyzer.countRaw() + "\n";
        text = text + "Organic cheeses with moisture > 41.0%: " + analyzer.countOrganicHighMoisture() + "\n";
        text = text + "Most common milk type: " + analyzer.findMostCommonMilk() + "\n";

        try {
            FileOutputStream out = new FileOutputStream(fileName);
            out.write(text.getBytes());
            out.close();
        } catch (Exception e) {
            System.out.println("Could not write to the file: " + fileName);
        }
    }
}