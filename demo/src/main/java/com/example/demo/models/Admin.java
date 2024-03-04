package com.example.demo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin  extends User{

    @Id
    @Column(name = "adminID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminID;
   
    Admin(String userName, String password, String email, String role, Long adminID) {
        super(userName, password, email, role);
        this.adminID = adminID;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }
    
}