package com.EUC.Electricity.RenewableEnergyTrading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.EUC.Electricity.RenewableEnergyTrading.Controller.EnergyController;
import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyAverages;
import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyData;
import com.EUC.Electricity.RenewableEnergyTrading.Repository.EnergyDataRepository;

@SpringBootTest
class RenewableEnergyTradingApplicationTests {

	@Mock
	private EnergyDataRepository energyDataRepository;

	@InjectMocks
	private EnergyController energyController;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCalculateAverages() {
		List<EnergyData> energyDataList = new ArrayList<>();
		EnergyData energyData = new EnergyData();
		energyData.setId("1");
		energyData.setDate(LocalDate.of(2021, 10, 1));
		energyData.setEnergyConsumption(100.0);
		energyData.setEnergyGeneration(200.0);
		energyData.setExportToGrid(100.0);
		energyDataList.add(energyData);

		when(energyDataRepository.findAll()).thenReturn(energyDataList);

		EnergyAverages energyAverages = energyController.calculateAverages();

		assertEquals(100.0, energyAverages.getAverageConsumption());
		assertEquals(200.0, energyAverages.getAverageGeneration());
		assertEquals(100.0, energyAverages.getExportToGrid());
	}

}
