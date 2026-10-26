package org.example;

public class Cheese {
    private int id;
    private String milkTreatment;
    private int organic;
    private double moisturePercent;
    private String milkType;

    public Cheese(int id, String milkTreatment, int organic, double moisturePercent, String milkType) {
        this.id = id;
        this.milkTreatment = milkTreatment;
        this.organic = organic;
        this.moisturePercent = moisturePercent;
        this.milkType = milkType;
    }

    public int getId() { return id; }
    public String getMilkTreatment() { return milkTreatment; }
    public int getOrganic() { return organic; }
    public double getMoisturePercent() { return moisturePercent; }
    public String getMilkType() { return milkType; }
}