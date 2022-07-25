package com.summitworks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.model.Kitchen;
import com.summitworks.service.KitchenService;

@RestController
@RequestMapping("/kitchen")
@CrossOrigin(origins = "http://localhost:4200")
public class KitchenController {
    
    private KitchenService kitchenService;

    public KitchenController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @PostMapping("/create")
    public HttpStatus createUser(@RequestBody Kitchen kitchen){
        ResponseEntity<String> response;
        Kitchen newKitchen = this.kitchenService.createKitchen(kitchen);
        if(newKitchen != null){
            response = new ResponseEntity<>("Kitchen created successfully", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("Kitchen already exists", HttpStatus.CONFLICT);
        }
        return response.getStatusCode();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Kitchen>> getAllUsers() {
        return new ResponseEntity<>(this.kitchenService.findAllKitchens(), HttpStatus.OK);
    }
}
