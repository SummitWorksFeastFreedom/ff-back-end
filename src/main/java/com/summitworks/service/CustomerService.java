package com.summitworks.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.summitworks.model.Customer;
import com.summitworks.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService implements UserDetailsService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = customerRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public Customer createCustomer(Customer user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return customerRepository.save(user);
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
