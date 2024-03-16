package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Order;
import com.example.demo.services.impl.OrderServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderServiceImpl orderService;

//    @PostMapping("/{customerId}")
//     public ResponseEntity<Order> createOrderForCustomer(
//             @PathVariable Long customerId,
//             @RequestBody Order order) {
        
//         // Order createdOrder = orderService.createOrderForCustomer(customerId, order);
//         // return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
//     }

   

    @GetMapping("/{id}")
    public Order getOrder(@RequestParam Long id) {
        return orderService.getOrder(id);
    }

    // @GetMapping("/{customerId}")
    // public Order getOrdersByCustomer(@PathVariable Long customerId) {
    //     return orderService.getOrderByCustomer(customerId);
    // }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
    return orderService.updateOrder(id, order);
    }

    
}
