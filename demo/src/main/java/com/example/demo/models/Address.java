package com.example.demo.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class Address {

    
    private String streetAddress;
    private int postalCode;
    private String city;
    private String country;

    Address(String streetAddress, int postalCode, String city, String country) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
    
    

