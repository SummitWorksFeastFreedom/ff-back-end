package com.summitworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.model.Customer;
import com.summitworks.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "https://resonant-kringle-e96671.netlify.app/")
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String hello() {
        return null;
    }
    
    @PostMapping("/create")
    public HttpStatus createUser(@RequestBody Customer customer){
        ResponseEntity<String> response;
        Customer newCustomer = this.customerService.createCustomer(customer);
        if(newCustomer != null){
            response = new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("Customer already exists", HttpStatus.CONFLICT);
        }
        return response.getStatusCode();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return new ResponseEntity<>(this.customerService.findAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = this.customerService.findCustomerByEmail(email);
        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
