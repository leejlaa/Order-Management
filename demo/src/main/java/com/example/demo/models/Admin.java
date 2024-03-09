package com.example.demo.models;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
@AttributeOverride(name = "ID", column = @Column(name = "admin_id"))
public class Admin  extends User{

    @ManyToOne
    @JoinColumn(name = "created_by_admin_id")
    private Admin createdByAdmin;

    @OneToMany(mappedBy = "createdByAdmin")
    private List<Admin> createdAdmins;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Customer> createdCustomers;

    public Admin getCreatedByAdmin() {
        return createdByAdmin;
    }

    public void setCreatedByAdmin(Admin createdByAdmin) {
        this.createdByAdmin = createdByAdmin;
    }

    public List<Admin> getCreatedAdmins() {
        return createdAdmins;
    }

    public void setCreatedAdmins(List<Admin> createdAdmins) {
        this.createdAdmins = createdAdmins;
    }

    public List<Customer> getCreatedCustomers() {
        return createdCustomers;
    }

    public void setCreatedCustomers(List<Customer> customers) {
        this.createdCustomers = customers;
    }

    public Admin(Long ID, String username, String password, String email, Admin createdByAdmin, List<Admin> createdAdmins, List<Customer> customers) {
        super(ID,username, password, email, "admin");
        this.createdByAdmin = createdByAdmin;
        this.createdAdmins = createdAdmins;
        this.createdCustomers = customers;
    }


   

   
}