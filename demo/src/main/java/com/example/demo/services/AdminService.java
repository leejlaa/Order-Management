package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.models.Product;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ProductRepository productRepository;


    public Admin createAdmin(Admin admin) {
        // Check if an admin with the same information exists
        Admin existingAdmin = adminRepository.findByUserName(admin.getUserName());
        if (existingAdmin != null) {
            return null;
        }

        // No duplicate admin found, proceed with saving the new admin
        return adminRepository.save(admin);
    }

    public Admin getAdmin(Long id) {
        return adminRepository.findById(id).orElse(null);
    }


    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin updateAdmin(Long id, Admin admin) {
        Admin existingAdmin = adminRepository.findById(id).orElse(null);
        if (existingAdmin != null) {
            existingAdmin.setUserName(admin.getUserName());
            existingAdmin.setPassword(admin.getPassword());
            return adminRepository.save(existingAdmin);
        }
        return null;
    }

    public boolean deleteAdmin(String userName) {
        Admin existingAdmin = adminRepository.findByUserName(userName);
        if (existingAdmin != null) {
            adminRepository.delete(existingAdmin);
            return true;
        }
        return false;
    }

    public boolean adminExists(String userName, String password) {
        Admin admin = adminRepository.findByUserNameAndPassword(userName, password);
        return admin != null;
    }

    

        @Transactional
        public Admin updateAdmin(Admin admin) {
            
            Admin updatedAdmin = adminRepository.save(admin);

            // Update related products
            List<Product> products = productRepository.findByAdmin(admin);
            for (Product product : products) {
                product.setAdmin(updatedAdmin);
                productRepository.save(product);
            }

            return updatedAdmin;
        }
}
