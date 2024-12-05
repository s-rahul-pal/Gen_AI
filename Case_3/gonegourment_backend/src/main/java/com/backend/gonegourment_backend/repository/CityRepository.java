package com.backend.gonegourment_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.gonegourment_backend.model.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByBrandId(Long brandId);
}

