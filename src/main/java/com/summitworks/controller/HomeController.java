package com.summitworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.service.HomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/login")
public class HomeController {
    
    @Autowired
    private HomeService homeService;

    @GetMapping
    public String home() {
        return "Hello World";
    }

    @PostMapping
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return homeService.login(email, password);
    }
    
}
