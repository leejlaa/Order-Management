package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.OrderProduct;
import com.example.demo.repositories.OrderProductRepository;

@Service
public class OrderProductService {
    
    @Autowired
    private OrderProductRepository orderProductRepository;
    
    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct createOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    public OrderProduct getOrderProduct(Long id) {
        return orderProductRepository.findById(id).orElse(null);
    }

    // public List<OrderProduct> getOrderProductsByOrderId(Long orderId) {
    //     return orderProductRepository.findByOrderId(orderId);
    // }

    public OrderProduct updateOrderProduct(Long id, OrderProduct orderProduct) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(id).orElse(null);
        if (existingOrderProduct != null) {
            existingOrderProduct.setOrder(orderProduct.getOrder());
            existingOrderProduct.setProduct(orderProduct.getProduct());
            existingOrderProduct.setQuantity(orderProduct.getQuantity());
            return orderProductRepository.save(existingOrderProduct);
        }
        return null;
    }

    public boolean deleteOrderProduct(Long id) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(id).orElse(null);
        if (existingOrderProduct != null) {
            orderProductRepository.delete(existingOrderProduct);
            return true;
        }
        return false;
    }
 
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }



}
