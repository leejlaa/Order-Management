package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Address;
import com.example.demo.services.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressConstoller {
    
    @Autowired
    private AddressService addressService;
    
    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @PutMapping
    public Address updateAddress(@RequestBody Long ID , Address address) {
        return addressService.updateAddress(ID, address);
    }
}
