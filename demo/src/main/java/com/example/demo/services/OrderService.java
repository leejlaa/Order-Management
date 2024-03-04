package com.example.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Order createOrderForCustomer(Long customerId, Order order) {
        java.util.Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new EntityNotFoundException("Customer not found with id: " + customerId);
        }
        Customer customer = optionalCustomer.get();
        order.setCustomer(customer);
        customer.addOrder(order);
        return orderRepository.save(order);
    }
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByCustomer(Long customerID) {
        return orderRepository.findByCustomerID(customerID);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCustomer(order.getCustomer());
            existingOrder.setProducts(order.getProducts());
            return orderRepository.save(existingOrder);
        }
        return null;
    }
}
