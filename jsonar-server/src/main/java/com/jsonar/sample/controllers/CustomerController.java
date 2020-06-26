package com.jsonar.sample.controllers;

import com.jsonar.sample.models.Customer;
import com.jsonar.sample.repositories.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Customer operations")
public class CustomerController {
    @Autowired private CustomerRepository customerRepository;

    @ApiOperation(value = "Return all customers", response = Customer[].class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Everything is fine"),
            @ApiResponse(code=400, message="Bad request, ask for support"),
            @ApiResponse(code=401, message="Your request is unauthorized")
    })
    @GetMapping("/customers")
    public ResponseEntity customers() {
        return ResponseEntity.ok(this.customerRepository.findAll());
    }
}
