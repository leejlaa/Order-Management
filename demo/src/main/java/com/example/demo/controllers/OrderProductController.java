package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.OrderProduct;
import com.example.demo.services.OrderProductService;

@RestController
@RequestMapping("/order-products")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @PostMapping
    public OrderProduct createOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.createOrderProduct(orderProduct);
    }

    @GetMapping("/{id}")
    public OrderProduct getOrderProduct(@PathVariable Long id) {
        return orderProductService.getOrderProduct(id);
    }

    @PutMapping("/{id}")
    public OrderProduct updateOrderProduct(@PathVariable Long id, @RequestBody OrderProduct orderProduct) {
        return orderProductService.updateOrderProduct(id, orderProduct);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrderProduct(@PathVariable Long id) {
        return orderProductService.deleteOrderProduct(id);
    }

    @GetMapping
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }
    
    
}
