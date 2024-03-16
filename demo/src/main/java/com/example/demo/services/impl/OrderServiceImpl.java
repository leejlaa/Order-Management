package com.example.demo.services.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.models.OrderProduct;
import com.example.demo.models.Product;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.OrderService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }


    public ArrayList<String>  allPreviousOrders(Long customerID) throws JsonProcessingException{

        ArrayList<String> orderList = new ArrayList<String>();
        List<Order> orders = orderRepository.findAllOrdersWithProductsByCustomerID(customerID);
        for (Order order : orders) {

            Long orderId = order.getOrderID();
           
            for (OrderProduct orderProduct : order.getOrderProducts()) {
                objectMapper.writeValueAsString(orderProduct);
                orderList.add(objectMapper.writeValueAsString(orderProduct));
            }
        }
        return orderList;
        
    }

     public void printAllOrdersToCSV(String filePath) {
        // String filePath = System.getProperty("user.dir") + File.separator + file;
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Order ID,Product ID,Product Name\n");


            List<Order> orders = orderRepository.findAllOrdersWithProducts();
            for (Order order : orders) {
                Long orderId = order.getOrderID();
               
                for (OrderProduct orderProduct : order.getOrderProducts()) {
                    Long productId = orderProduct.getProduct().getProductID();
                    String productName = orderProduct.getProduct().getProductName();

                    writer.append(String.format("%d,%d,%s\n", orderId, productId, productName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public Order createOrderForCustomer(Long customerId, List<Long> productIDs, List<Integer> quantities) {
        // Check if customer exists
        Order existingOrder = new Order();
        java.util.Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            // // Customer exists, fetch existing order if any
            // existingOrder = orderRepository.findByCustomerID(customerId);
            // if (existingOrder == null) {
            //     // No existing order, create a new one
            //     existingOrder = new Order();
            // }
            // Populate order details
            List<Product> products = productRepository.findAllById(productIDs);
            List<OrderProduct> orderProducts = new ArrayList<>();
            for (Product product : products) {
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setProduct(product);
                orderProduct.setQuantity(quantities.get(products.indexOf(product)));
                orderProduct.setPrice((long) (quantities.get(products.indexOf(product)) * product.getPrice()));
                orderProduct.setOrder(existingOrder);
                orderProducts.add(orderProduct);
                productRepository.decreaseQuantityByProductName(product.getProductName(), quantities.get(products.indexOf(product)));
            }
            // Save products and order products
            orderProductRepository.saveAll(orderProducts);
            existingOrder.setOrderProducts(orderProducts);
            // Set customer and save order
            existingOrder.setCustomer(optionalCustomer.get());
            
        } else {
            // Customer does not exist, handle as required (e.g., throw exception, return null)
           
        }

        System.out.println("Ordered successfully!");
        return orderRepository.save(existingOrder);

    }
    


    public String exportDataToJson (Long customerID) {
       

        List<Order> orders = orderRepository.findByCustomerID(customerID);
        List<OrderProduct> orderProducts = new ArrayList<>();

        for (Order order : orders) {
            orderProducts = orderProductRepository.findByOrderId(order.getOrderID());

            // System.out.println("Order ID: "+order.getOrderID());
            // for(OrderProduct orderProduct: orderProducts){
            //     System.out.println(
            // " product name: "+orderProduct.getProduct().getProductName() + " quantity: "+orderProduct.getQuantity()
            // + " price: "+orderProduct.getPrice());
            // }

            
        }
        try {
            return objectMapper.writeValueAsString(orderProducts);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
            return null; 
        }
    
    }

    public List<Order> findByCustomerID(Long customerID) {
        return orderRepository.findByCustomerID(customerID);
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
            //existingOrder.setProducts(order.getProducts());
            return orderRepository.save(existingOrder);
        }
        return null;
    }
}
