package com.EUC.Electricity.RenewableEnergyTrading;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.EUC.Electricity.RenewableEnergyTrading.Controller.EnergyController;
import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyAverages;
import com.EUC.Electricity.RenewableEnergyTrading.Model.EnergyData;
import com.EUC.Electricity.RenewableEnergyTrading.Repository.EnergyDataRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EnergyControllerTest {
    @Mock
    private EnergyDataRepository energyDataRepository;

    @InjectMocks
    private EnergyController energyController;

}
