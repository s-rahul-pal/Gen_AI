package com.backend.promotionfinder.service;

import com.backend.promotionfinder.Promotion;
import com.backend.promotionfinder.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    // Fetch all promotions from the database
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    // Fetch promotions by country from the database
    public List<Promotion> getPromotionsByCountry(String country) {
        return promotionRepository.findByCountry(country);
    }

    // Fetch distinct countries from the promotions
    public List<String> getAllCountries() {
        return promotionRepository.findAll()
                                   .stream()
                                   .map(Promotion::getCountry)
                                   .distinct()
                                   .collect(Collectors.toList());
    }
    
    
}

