package com.summitworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.summitworks.model.Customer;
import com.summitworks.repository.CustomerRepository;

@Service
public class HomeService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer login(String email, String password) {
        Customer response;
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            if (passwordEncoder.matches(password, customer.getPassword())) {
                response = customer;
            } else {
                response = null;
            }
        } else {
            response = null;
        }
        return response;
    }
    
}
