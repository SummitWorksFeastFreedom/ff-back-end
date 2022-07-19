package com.summitworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.summitworks.details.CustomerDetails;
import com.summitworks.model.Customer;
import com.summitworks.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(customer.getId());
        if(optionalCustomer.isEmpty()){
            return this.customerRepository.save(customer);
        }
        return null;
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customerList = this.customerRepository.findAll();
        return customerList;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = this.customerRepository.findByEmail(email);
        if(customer == null){
            throw new UsernameNotFoundException("Customer not found");
        }
        return new CustomerDetails(customer);
    }
    
}
