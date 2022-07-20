package com.summitworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summitworks.model.Kitchen;
import com.summitworks.repository.KitchenRepository;

@Service
public class KitchenService {
    
    private KitchenRepository kitchenRepository;

    public KitchenService (KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    public Kitchen createKitchen(Kitchen kitchen) {
        Optional<Kitchen> optionalKitchen = this.kitchenRepository.findById(kitchen.getId());
        if(optionalKitchen.isEmpty()){
            return this.kitchenRepository.save(kitchen);
        }
        return null;
    }

    public List<Kitchen> findAllKitchens() {
        List<Kitchen> kitchenList = this.kitchenRepository.findAll();
        return kitchenList;
    }

}
