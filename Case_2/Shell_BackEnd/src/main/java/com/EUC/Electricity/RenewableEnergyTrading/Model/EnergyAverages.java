package com.EUC.Electricity.RenewableEnergyTrading.Model;

import lombok.Data;

@Data
public class EnergyAverages {

    double averageConsumption;
    double averageGeneration;
    double exportToGrid;

    public EnergyAverages(double averageConsumption, double averageGeneration, double exportToGrid) {
        this.averageConsumption = averageConsumption;
        this.averageGeneration = averageGeneration;
        this.exportToGrid = exportToGrid;
    }
}
