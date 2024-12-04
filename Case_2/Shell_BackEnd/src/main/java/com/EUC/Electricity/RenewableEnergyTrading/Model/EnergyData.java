package com.EUC.Electricity.RenewableEnergyTrading.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.LocalDate;

@Data
@Document(collection = "EnergyData")
public class EnergyData {
    @Id
    private String id;
    private LocalDate date;
    private double energyConsumption;
    private double energyGeneration;
    private double exportToGrid;

    @Override
    public String toString() {
        return "EnergyData{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", energyConsumption=" + energyConsumption +
                ", energyGeneration=" + energyGeneration +
                ", exportToGrid=" + exportToGrid +
                '}';
    }
}
