package com.backend.gonegourment_backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.gonegourment_backend.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}

