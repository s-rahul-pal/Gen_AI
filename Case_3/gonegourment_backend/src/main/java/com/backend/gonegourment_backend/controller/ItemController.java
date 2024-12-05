package com.backend.gonegourment_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.backend.gonegourment_backend.model.UnavailableItem;
import com.backend.gonegourment_backend.repository.UnavailableItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/unavailable-items")

public class ItemController {
    private final UnavailableItemRepository unavailableItemRepository;

    public ItemController(UnavailableItemRepository unavailableItemRepository) {
        this.unavailableItemRepository = unavailableItemRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000") 
    @GetMapping
    public List<UnavailableItem> getItemsByCity(@RequestParam Long cityId) {
        return unavailableItemRepository.findByCityId(cityId);
    }
}

