package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setCurrentResidence(customer.getCurrentResidence());
            existingCustomer.setDateOfBirth(customer.getDateOfBirth());
            existingCustomer.setOrders(customer.getOrders());
            existingCustomer.setEmail(customer.getEmail());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public boolean deleteCustomer(String userName) {
        Customer existingCustomer = customerRepository.findByUserName(userName);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
            return true;
        }
        return false;
    }

    public Customer getCustomerByUserName(String userName) {
        return customerRepository.findByUserName(userName);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public boolean customerExists(String username, String password) {
        Customer customer = customerRepository.findByUserNameAndPassword(username, password);
        return customer != null;
    }

    
}
