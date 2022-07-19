package com.summitworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.model.Kitchen;
import com.summitworks.service.KitchenService;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {
    
    @Autowired
    private KitchenService kitchenService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Kitchen kitchen){
        ResponseEntity<String> response;
        Kitchen newCustomer = this.kitchenService.createKitchen(kitchen);
        if(newCustomer != null){
            response = new ResponseEntity<>("Kitchen created successfully", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("Kitchen already exists", HttpStatus.CONFLICT);
        }
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Kitchen>> getAllUsers() {
        return new ResponseEntity<>(this.kitchenService.findAllKitchens(), HttpStatus.ACCEPTED);
    }
}
