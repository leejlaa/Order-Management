package com.example.demo.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends User{

    @Id
    @Column(name = "customerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Address currentResidence;
    private List<Order> orders;

    Customer(String userName, String password, String email, String role, Long customerID, String firstName, String lastName, Date dateOfBirth, Address currentResidence, List<Order> orders) {
        super(userName, password, email, role);
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.currentResidence = currentResidence;
        this.orders = orders;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getCurrentResidence() {
        return currentResidence;
    }

    public void setCurrentResidence(Address currentResidence) {
        this.currentResidence = currentResidence;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}

    


