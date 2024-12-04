package com.EUC.Electricity.RenewableEnergyTrading.Model;

import lombok.Data;

import java.util.List;


@Data
public class EnergyDataStatistics {

    private List<EnergyData> energyDataList;
    private double maxEnergyGenerated;
    private double minEnergyGenerated;
    private double maxEnergyConsumed;
    private double minEnergyConsumed;



    public EnergyDataStatistics(List<EnergyData> energyDataList, double maxEnergyGenerated, double minEnergyGenerated, double maxEnergyConsumed, double minEnergyConsumed) {
        this.energyDataList = energyDataList;
        this.maxEnergyGenerated = maxEnergyGenerated;
        this.minEnergyGenerated = minEnergyGenerated;
        this.maxEnergyConsumed = maxEnergyConsumed;
        this.minEnergyConsumed = minEnergyConsumed;
    }
}
