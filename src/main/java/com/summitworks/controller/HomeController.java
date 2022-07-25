package com.summitworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.model.Customer;
import com.summitworks.service.HomeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
    
    @Autowired
    private HomeService homeService;

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer) {
        return homeService.login(customer.getEmail(), customer.getPassword());
    }
    
}
