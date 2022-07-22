package com.summitworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.summitworks.model.Customer;
import com.summitworks.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer createCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setId(0);
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
        newCustomer.setRole(customer.getRole());
        customerRepository.save(newCustomer);
        return newCustomer;
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customerList = this.customerRepository.findAll();
        return customerList;
    }
    
    public Customer findCustomerById(int id) {
        Optional<Customer> customer = this.customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    public Customer findCustomerByEmail(String email) {
        Customer customer = this.customerRepository.findByEmail(email);
        return customer;
    }
}
