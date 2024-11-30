package com.backend.promotionfinder.controller;

import com.backend.promotionfinder.Promotion;
import com.backend.promotionfinder.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promotionService; // Service to fetch promotions from the database

    // Endpoint to get all promotions
    @GetMapping("/promotions")
    public List<Promotion> getPromotions() {
        return promotionService.getAllPromotions();
    }

    // Endpoint to get promotions by country
    @GetMapping("/promotions/{country}")
    public List<Promotion> getPromotionsByCountry(@PathVariable String country) {
        return promotionService.getPromotionsByCountry(country);
    }

    // Endpoint to get list of countries
    @GetMapping("/countries")
    public List<String> getCountries() {
        return promotionService.getAllCountries();
    }
    
    
}
