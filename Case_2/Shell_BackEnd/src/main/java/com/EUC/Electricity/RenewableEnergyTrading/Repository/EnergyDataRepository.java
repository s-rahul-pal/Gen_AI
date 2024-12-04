package com.EUC.Electricity.RenewableEnergyTrading.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyData;
import java.time.LocalDate;

import java.util.List;

public interface EnergyDataRepository extends MongoRepository<EnergyData, String> {

    List<EnergyData> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
