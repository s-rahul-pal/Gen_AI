package com.EUC.Electricity.RenewableEnergyTrading.Model;

public class MonthlySummary {
    private final double totalEnergyConsumption;
    private final double totalEnergyGeneration;
    private final double totalExportToGrid;

    public MonthlySummary(double totalEnergyConsumption, double totalEnergyGeneration, double totalExportToGrid) {
        this.totalEnergyConsumption = totalEnergyConsumption;
        this.totalEnergyGeneration = totalEnergyGeneration;
        this.totalExportToGrid = totalExportToGrid;
    }

    public double getTotalEnergyConsumption() {
        return totalEnergyConsumption;
    }

    public double getTotalEnergyGeneration() {
        return totalEnergyGeneration;
    }

    public double getTotalExportToGrid() {
        return totalExportToGrid;
    }

}
