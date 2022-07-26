package com.summitworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summitworks.model.Kitchen;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Integer> {
    
}
