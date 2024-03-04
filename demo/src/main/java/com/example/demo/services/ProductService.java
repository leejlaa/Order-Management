package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired // sets the repository to be used by the service in the constructor.
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setAvailabilityDate(product.getAvailabilityDate());
            existingProduct.setReleaseDate(product.getReleaseDate());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public boolean deleteProduct(String productName) {
       Product existingProduct = productRepository.findByProductName(productName);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }



}
