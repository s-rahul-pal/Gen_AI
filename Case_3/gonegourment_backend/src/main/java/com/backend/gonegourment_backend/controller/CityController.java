package com.backend.gonegourment_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.backend.gonegourment_backend.model.City;
import com.backend.gonegourment_backend.repository.CityRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cities")

public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000") 
    @GetMapping("/{brandId}")
    public List<City> getCitiesByBrand(@PathVariable Long brandId) {
        return cityRepository.findByBrandId(brandId);
    }
}
