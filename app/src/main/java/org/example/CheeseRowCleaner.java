package org.example;

import java.util.ArrayList;

public class CheeseRowCleaner {

    public String[] clean(String line) {
        ArrayList<String> values = new ArrayList<>();
        String current = "";
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                insideQuotes = !insideQuotes;
            } else if (c == ',' && !insideQuotes) {
                values.add(current.trim());
                current = "";
            } else {
                current = current + c;
            }
        }
        values.add(current.trim());

        String[] result = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }
}