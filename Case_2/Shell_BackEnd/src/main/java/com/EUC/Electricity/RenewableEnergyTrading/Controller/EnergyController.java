package com.EUC.Electricity.RenewableEnergyTrading.Controller;

import java.lang.System.Logger;
import java.time.LocalDate;
import java.util.List;

import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyDataStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyAverages;
import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyData;
import com.EUC.Electricity.RenewableEnergyTrading.Repository.EnergyDataRepository;
import com.EUC.Electricity.RenewableEnergyTrading.Services.EnergyDataService;

@RestController
@CrossOrigin(origins = "*")
public class EnergyController {

    @Autowired
    EnergyDataRepository energyDataRepository;

    EnergyDataService energyDataService;

    @GetMapping("/energy")
    public String getEnergy() {
        return "Energy";
    }

    @PostMapping("/energy")
    public ResponseEntity<String> postEnergy(@RequestBody EnergyData energyData) {
        System.out.println(energyData);
        energyDataRepository.save(energyData);
        return new ResponseEntity<>("Data Saved", HttpStatus.CREATED);
    }

    @GetMapping("/averageEnergyConsumption")
    public EnergyAverages calculateAverages() {
        List<EnergyData> energyDataList = energyDataRepository.findAll();

        double totalConsumption = 0.0;
        double totalGeneration = 0.0;
        double totalExportToGrid = 0.0;

        for (EnergyData data : energyDataList) {
            totalConsumption += data.getEnergyConsumption();
            totalGeneration += data.getEnergyGeneration();
            totalExportToGrid += data.getExportToGrid();
        }
        return new EnergyAverages(totalConsumption, totalGeneration, totalExportToGrid);
    }

    @GetMapping("/energy-data/{timeFrame}")
    public EnergyDataStatistics getEnergyDataForTimeFrame(@PathVariable String timeFrame) {
        LocalDate currentDate = LocalDate.now().withYear(2023);
        System.out.println(currentDate);
        LocalDate startDate;
        System.out.println(timeFrame);
        switch (timeFrame) {
            case "Current Week":
                startDate = currentDate.minusDays(6); // Data for the past 7 days
                break;
            case "Current Month":
                startDate = currentDate.minusMonths(1); // Data for the past month
                break;
            case "Current Year":
                startDate = currentDate.minusYears(1); // Data for the past year
                break;
            default:
                throw new IllegalArgumentException("Invalid time frame.");
        }
        System.out.println(startDate);
        System.out.println(currentDate);
        System.out.println(energyDataRepository.findByDateBetween(startDate, currentDate));
        List<EnergyData> energyDataList = energyDataRepository.findByDateBetween(startDate, currentDate);
        System.out.println(energyDataList);
        double maxEnergyGenerated = energyDataList.stream()
                .mapToDouble(EnergyData::getEnergyGeneration)
                .max()
                .orElse(0.0);
        double minEnergyGenerated = energyDataList.stream()
                .mapToDouble(EnergyData::getEnergyGeneration)
                .min()
                .orElse(0.0);

        double maxEnergyConsumed = energyDataList.stream()
                .mapToDouble(EnergyData::getEnergyConsumption)
                .max()
                .orElse(0.0);
        double minEnergyConsumed = energyDataList.stream()
                .mapToDouble(EnergyData::getEnergyConsumption)
                .min()
                .orElse(0.0);

        EnergyDataStatistics statistics = new EnergyDataStatistics(energyDataList, maxEnergyGenerated,
                minEnergyGenerated, maxEnergyConsumed, minEnergyConsumed);
        System.out.println(statistics);
        return statistics;
    }

}
