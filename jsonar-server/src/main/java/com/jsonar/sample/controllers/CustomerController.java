package com.jsonar.sample.controllers;

import com.jsonar.sample.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity customers() {
        return ResponseEntity.ok(this.customerRepository.findAll());
    }
}
