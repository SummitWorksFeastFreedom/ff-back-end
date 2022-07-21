package com.summitworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.model.Customer;
import com.summitworks.service.HomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "https://resonant-kringle-e96671.netlify.app/")
public class HomeController {
    
    @Autowired
    private HomeService homeService;

    @GetMapping("/login/{email}/{password}")
    public Customer login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return homeService.login(email, password);
    }
    
}
