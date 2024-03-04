package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.repositories.AdminRepository;

@Service
public class AdminService {
    
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
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

}
