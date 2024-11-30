package com.backend.promotionfinder.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.promotionfinder.Promotion;

import java.util.Arrays;
import java.util.List;

@RestController
public class PromotionController {

    
    // Hardcoded promotions list
    private List<Promotion> promotions = Arrays.asList(
        new Promotion("1", "Holiday Discount", "India",Arrays.asList("Applies only if total bill is more than 2999/-Rs") , Arrays.asList("Hyderabad", "Warangal")),
        new Promotion("1", "Mega Sale Discount", "India",Arrays.asList("Minimum purchase should be 4999/-Rs", "Applies only on the selected products") ,Arrays.asList("Basti", "Gorakhpur")),
        new Promotion("2", "Summer Sale 2025", "USA",Arrays.asList("Offer valid from June 1, 2025 to August 31, 2025.", "Discounts are applicable on selected items only.", "Cannot be combined with other promotions or discounts.", "Available only at participating locations.", "No cash value or exchanges allowed.") , Arrays.asList("New York", "Los Angeles", "Miami")),
        new Promotion("2", "Student Discount", "USA",Arrays.asList("10% Off for Students", "Offer available to all students with a valid student ID.", "Limit one use per student ID.", "Available only at participating locations.") , Arrays.asList("Los Angeles", "Boston", "New York", "Toronto")),
        new Promotion("3", "Fiesta Mexicana 2025", "Mexico", Arrays.asList("Get 20% off all items in-store and online.", "Discount applies to full-priced items only; excludes clearance items.") , Arrays.asList("Mexico City", "Guadalajara", "Monterrey", "Cancún", "Puebla"))
    );

    // Hardcoded countries list
    private List<String> countries = Arrays.asList("India", "USA", "Mexico");


    // Endpoint to get all promotions
    @GetMapping("/promotions")
    public List<Promotion> getPromotions() {
        return promotions;
    }

    // Endpoint to get promotions by country
    @GetMapping("/promotions/{country}")
    public List<Promotion> getPromotionsByCountry(@PathVariable String country) {
        // Return filtered list based on country
        return filterPromotionsByCountry(country);
    }

    // Endpoint to get list of countries
    @GetMapping("/countries")
    public List<String> getCountries() {
        return countries;
    }


    // Helper method to filter promotions by country
    private List<Promotion> filterPromotionsByCountry(String country) {
        return promotions.stream()
                         .filter(promotion -> promotion.getCountry().equalsIgnoreCase(country))
                         .toList();
    }
}

