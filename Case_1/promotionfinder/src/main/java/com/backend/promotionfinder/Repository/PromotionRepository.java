package com.backend.promotionfinder.Repository;


import com.backend.promotionfinder.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // Custom query to find promotions by country
    List<Promotion> findByCountry(String country);
}

