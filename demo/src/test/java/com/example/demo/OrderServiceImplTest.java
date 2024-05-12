package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.models.OrderProduct;
import com.example.demo.models.Product;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.impl.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;


@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderProductRepository orderProductRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private OrderServiceImpl orderService;

  
    private  SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");



    // @BeforeEach
    // public void setup() {
    //     MockitoAnnotations.openMocks(this);
    // }

    @Test
    public void testCreateOrderForCustomer() throws Exception{
        // Create a sample customer
        Customer customer = new Customer();
        customer.setID(1L); // Corrected method name
        customer.setFirstName("John");
        customer.setLastName("Doe");
        
    
        // Create a sample order
        Order order = new Order();
        order.setOrderID(1L);
    
        // Mock customer repository behavior
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
    
        // Mock order repository behavior
        when(orderRepository.save(order)).thenReturn(order);
    
        // Call the method under test
        Order createdOrder = orderService.createOrderForCustomer(1L, order);
    
        // Verify that the customer repository is called with the correct customer ID
        verify(customerRepository, times(1)).findById(1L);
    
        // Verify that the order repository is called to save the order
        verify(orderRepository, times(1)).save(order);
    
        // Verify that the order returned by the method under test is the same as the one saved
        assertEquals(order, createdOrder);
    }

    
    
}

    

