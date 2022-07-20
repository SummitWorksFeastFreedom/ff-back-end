package com.summitworks.service;

import java.util.Optional;

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

    public String login(String email, String password) {
        String response = "";
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            if (passwordEncoder.matches(password, customer.getPassword())) {
                response = "Login Successful";
            } else {
                response = "Invalid Password";
            }
        } else {
            response = "Invalid Email";
        }
        return response;
    }
    
}
