package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CheeseReader {

    public ArrayList<String> readLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Could not find the file: " + fileName);
        }
        return lines;
    }
}
