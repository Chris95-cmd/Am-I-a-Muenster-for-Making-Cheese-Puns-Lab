package org.example;

public class CheeseAnalyzer {
    private CheeseList cheeses;

    public CheeseAnalyzer(CheeseList cheeses) {
        this.cheeses = cheeses;
    }

    private int countTreatment(String target) {
        int count = 0;
        for (int i = 0; i < cheeses.size(); i++) {
            String treatment = cheeses.get(i).getMilkTreatment();
            if (treatment.equalsIgnoreCase(target)) {
                count++;
            }
        }
        return count;
    }

    private int countMilkType(String target) {
        int count = 0;
        for (int i = 0; i < cheeses.size(); i++) {
            String milkType = cheeses.get(i).getMilkType();
            if (milkType.equalsIgnoreCase(target)) {
                count++;
            }
        }
        return count;
    }

    public int countPasteurized() {
        return countTreatment("Pasteurized");
    }

    public int countRaw() {
        return countTreatment("Raw Milk");
    }

    public int countOrganicHighMoisture() {
        int count = 0;
        for (int i = 0; i < cheeses.size(); i++) {
            Cheese c = cheeses.get(i);
            if (c.getOrganic() != -1 && c.getMoisturePercent() != -1) {
                if (c.getOrganic() == 1 && c.getMoisturePercent() > 41.0) {
                    count++;
                }
            }
        }
        return count;
    }

    public String findMostCommonMilk() {
        int cow = countMilkType("Cow");
        int goat = countMilkType("Goat");
        int ewe = countMilkType("Ewe");
        int buffalo = countMilkType("Buffalo");

        String mostCommon = "Cow";
        int highest = cow;
        if (goat > highest) {
            mostCommon = "Goat";
            highest = goat;
        }
        if (ewe > highest) {
            mostCommon = "Ewe";
            highest = ewe;
        }
        if (buffalo > highest) {
            mostCommon = "Buffalo";
            highest = buffalo;
        }
        return mostCommon + " (" + highest + " cheeses)";
    }
}