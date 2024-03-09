package com.example.demo.models;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.services.AddressService;
import com.example.demo.services.AdminService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.OrderProductService;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;

@Component
public class Main {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderProductService orderProductService;
    
    static Scanner  scanner = new Scanner(System.in);
    
    public void  main(){
        
        System.out.println("Welcome to Order Management System");


        System.out.println("Please enter: \n1) for login \n2) for signing up:");

        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            
        
            System.out.println("Please enter your username:");
            String username = scanner.nextLine();
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
    
            while(!adminService.adminExists(username, password)){
                System.out.println("Invalid username or password. Please try again.");
                System.out.println("Please enter your username:");
                username = scanner.nextLine();
                System.out.println("Please enter your password:");
                password = scanner.nextLine();
            }

            System.out.println("Welcome " + username);
            System.out.println("\nEnter 1 for adding a new user.\nEnter 2 for getting s list of all users.\nEnter 3 for deleting a specific user.");

            
    
        }else if(choice == 2){

            System.out.println("Please enter your username:");
            String username = scanner.nextLine();
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

        }else{
            System.out.println("Invalid choice");
        }
        
    }


    
}
