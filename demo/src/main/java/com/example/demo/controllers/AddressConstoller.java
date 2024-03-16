package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.demo.models.Address;
import com.example.demo.services.impl.AddressServiceImpl;

@RestController
@RequestMapping("/addresses")
public class AddressConstoller {
    
    @Autowired
    private AddressServiceImpl addressServiceImpl;
    
    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressServiceImpl.createAddress(address);
    }

    @GetMapping
    public List<Address> getAddresses() {
        return addressServiceImpl.getAddresses();
    }

    @PutMapping
    public Address updateAddress(@RequestBody Long ID , Address address) {
        return addressServiceImpl.updateAddress(ID, address);
    }

    
    @DeleteMapping("{ID}")
    public ResponseEntity<String> deleteResource(@PathVariable Long ID) {
        addressServiceImpl.deleteAddress(ID);
        return ResponseEntity.ok("Address deleted successfully");
    }
}
