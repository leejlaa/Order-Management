package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Address;
import com.example.demo.repositories.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setCountry(address.getCountry());
            existingAddress.setCity(address.getCity());
            existingAddress.setPostalCode(address.getPostalCode());
            existingAddress.setStreetAddress(address.getStreetAddress());
            return addressRepository.save(existingAddress);
        }
        return null;
    }

    public boolean deleteAddress(Long id) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            addressRepository.delete(existingAddress);
            return true;
        }
        return false;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }
    
    
}
