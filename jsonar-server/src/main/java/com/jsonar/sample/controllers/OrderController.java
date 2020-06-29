package com.jsonar.sample.controllers;

import com.jsonar.sample.models.order.Order;
import com.jsonar.sample.models.order.OrderDetail;
import com.jsonar.sample.repositories.OrderDetailRepository;
import com.jsonar.sample.repositories.OrderRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Order operations")
public class OrderController {
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderDetailRepository orderDetailRepository;

    @ApiOperation(value = "Return orders that correlated to customer", response = Order[].class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Everything is fine"),
            @ApiResponse(code=400, message="Bad request, ask for support"),
            @ApiResponse(code=403, message="Forbidden: Access Denied")
    })
    @GetMapping("/customerOrders/{customerNumber}")
    public ResponseEntity customerOrders(@PathVariable Integer customerNumber) {
        return ResponseEntity.ok(this.orderRepository.findByCustomerNumber(customerNumber));
    }

    @ApiOperation(value = "Return order details correlated order", response = OrderDetail[].class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Everything is fine"),
            @ApiResponse(code=400, message="Bad request, ask for support"),
            @ApiResponse(code=403, message="Forbidden: Access Denied")
    })
    @GetMapping("/orderDetails/{orderNumber}")
    public ResponseEntity orderDetails(@PathVariable Integer orderNumber) {
        return ResponseEntity.ok(this.orderDetailRepository.findByOrderNumber(orderNumber));
    }
}
