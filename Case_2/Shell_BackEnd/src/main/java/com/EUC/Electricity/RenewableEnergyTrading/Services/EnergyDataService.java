package com.EUC.Electricity.RenewableEnergyTrading.Services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyData;
import com.EUC.Electricity.RenewableEnergyTrading.Repository.EnergyDataRepository;

@Service
public class EnergyDataService {
    // private final EnergyDataRepository energyDataRepository;

    @Autowired
    private EnergyDataRepository energyDataRepository;

    

}
