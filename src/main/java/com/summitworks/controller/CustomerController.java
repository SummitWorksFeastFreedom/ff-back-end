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

import com.summitworks.model.Customer;
import com.summitworks.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Customer customer){
        ResponseEntity<String> response;
        Customer newCustomer = this.customerService.createCustomer(customer);
        if(newCustomer != null){
            response = new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("Customer already exists", HttpStatus.CONFLICT);
        }
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return new ResponseEntity<>(this.customerService.findAllCustomers(), HttpStatus.ACCEPTED);
    }
}
