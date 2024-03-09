package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Admin;
import com.example.demo.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    Product findByProductName(@Param("productName") String productName);
    
    @Query("SELECT p FROM Product p WHERE p.admin = :admin")
    List<Product> findByAdmin(@Param("admin") Admin admin);

    
    
    
}
