package org.example;

public class CheeseParser {
    private CheeseRowCleaner cleaner;
    private int idCol;
    private int treatmentCol;
    private int organicCol;
    private int moistureCol;
    private int milkTypeCol;

    public CheeseParser(String headerLine, CheeseRowCleaner cleaner) {
        this.cleaner = cleaner;
        String[] headers = cleaner.clean(headerLine);
        idCol = findColumn(headers, "CheeseId");
        treatmentCol = findColumn(headers, "MilkTreatmentTypeEn");
        organicCol = findColumn(headers, "Organic");
        moistureCol = findColumn(headers, "MoisturePercent");
        milkTypeCol = findColumn(headers, "MilkTypeEn");
    }

    private int findColumn(String[] headers, String name) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private String getValue(String[] values, int col) {
        if (col >= 0 && col < values.length) {
            return values[col];
        }
        return "";
    }

    public Cheese parseLine(String line) {
        if (line.trim().isEmpty()) {
            return null;
        }

        String[] values = cleaner.clean(line);

        String treatment = getValue(values, treatmentCol);
        String milkType = getValue(values, milkTypeCol);

        int id = -1;
        int organic = -1;
        double moisture = -1;

        try {
            id = Integer.parseInt(getValue(values, idCol));
        } catch (Exception e) {
            //
        }
        try {
            organic = Integer.parseInt(getValue(values, organicCol));
        } catch (Exception e) {
            //
        }
        try {
            moisture = Double.parseDouble(getValue(values, moistureCol));
        } catch (Exception e) {
            //
        }

        return new Cheese(id, treatment, organic, moisture, milkType);
    }
}