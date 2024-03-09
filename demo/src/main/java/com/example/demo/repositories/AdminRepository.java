package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


    @Query("SELECT a FROM Admin a WHERE a.userName = :userName")
    Admin findByUserName(@Param("userName") String userName);

    @Query("SELECT a FROM Admin a WHERE a.userName = :userName AND a.password = :password")
    Admin findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
    
} 

    

