package com.backend.gonegourment_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.gonegourment_backend.model.UnavailableItem;

import java.util.List;

public interface UnavailableItemRepository extends JpaRepository<UnavailableItem, Long> {
    List<UnavailableItem> findByCityId(Long cityId);
}
