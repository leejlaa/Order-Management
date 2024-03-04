package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @Column(name = "adminID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    private String productName;
    private Double price;
    private Date releaseDate;
    private Date availabilityDate;
    private int quantity;

    Product(Long productID, String productName, Double price, Date releaseDate, Date availabilityDate, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.releaseDate = releaseDate;
        this.availabilityDate = availabilityDate;
        this.quantity = quantity;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(Date availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
