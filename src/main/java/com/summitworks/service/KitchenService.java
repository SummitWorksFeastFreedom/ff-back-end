package com.summitworks.service;

import java.util.List;

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
        Kitchen newKitchen = new Kitchen();
        newKitchen.setId(0);
        newKitchen.setServiceProviderName(kitchen.getServiceProviderName());
        newKitchen.setAddress(kitchen.getAddress());
        newKitchen.setEmail(kitchen.getEmail());
        newKitchen.setPhone(kitchen.getPhone());
        kitchenRepository.save(newKitchen);
        return newKitchen;
    }

    public List<Kitchen> findAllKitchens() {
        List<Kitchen> kitchenList = this.kitchenRepository.findAll();
        return kitchenList;
    }

}
