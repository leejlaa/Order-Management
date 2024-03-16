package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Order;

public interface OrderService {

    public Order createOrderForCustomer(Long customerId, List<Long> productIDs, List<Integer> quantities);
    public List<Order> findByCustomerID(Long customerID);
    public String exportDataToJson (Long customerID);
    public List<Order> getOrdersByCustomer(Long customerID);
    public Order getOrder(Long id);
    public Order updateOrder(Long id, Order order);
    
}
