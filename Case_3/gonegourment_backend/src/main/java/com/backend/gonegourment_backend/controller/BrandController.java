package com.backend.gonegourment_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.backend.gonegourment_backend.model.Brand;
import com.backend.gonegourment_backend.repository.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins = "http://localhost:3000") 
public class BrandController {
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    
    @CrossOrigin(origins = "http://localhost:3000") 
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
