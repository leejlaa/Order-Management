// package com.example.demo.models;


// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Locale;
// import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import com.example.demo.services.AdminService;
// import com.example.demo.services.CustomerService;
// import com.example.demo.services.OrderProductService;
// import com.example.demo.services.OrderService;
// import com.example.demo.services.ProductService;
// import com.example.demo.services.impl.AddressService;

// @Component
// public class Main {

//     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

//     @Autowired
//     private AdminService adminService;
//     @Autowired
//     private CustomerService customerService;
//     @Autowired
//     private ProductService productService;
//     @Autowired
//     private OrderService orderService;
//     @Autowired
//     private AddressService addressService;
//     @Autowired
//     private OrderProductService orderProductService;
    
//     static Scanner  scanner = new Scanner(System.in);
    
//     public void  main() throws ParseException{
        
//         System.out.println("Welcome to Order Management System");


        

        
        
            
        
//             System.out.println("Please enter your username:");
//             String userName = scanner.nextLine();

//             System.out.println("Please enter your password:");
//             String password = scanner.nextLine();

//             if(adminService.adminExists(userName,password)){
    
//             while(!adminService.adminExists(userName, password)){
//                 System.out.println("Invalid username or password. Please try again.");
//                 System.out.println("Please enter your username:");
//                 userName = scanner.nextLine();
//                 System.out.println("Please enter your password:");
//                 password = scanner.nextLine();
//             }

//             System.out.println("Welcome " + userName);
//             System.out.println("Enter \n1 for user administration\n2 for product catalog \n3 for list of all orders");

//             int choice2 = scanner.nextInt();


//             switch (choice2){
//                 case 1:
//                     System.out.println("\nEnter 1 for adding a new user.\nEnter 2 for getting s list of all users.\nEnter 3 for deleting a specific user.");

//                     int adminChoice = scanner.nextInt();
                   
//                 switch (adminChoice) {
//                 case 1:
//                     System.out.println("Please enter the role of the user you want to create customer/admin:");
//                     String role = scanner.nextLine();

//                     if("admin".equals(role)){
//                         Admin admin = new Admin();
//                         System.out.println("Please enter the username of the admin:");
//                         String adminUserName = scanner.nextLine();
//                         admin.setUserName(adminUserName);
//                         System.out.println("Please enter the password of the admin:");
//                         String adminPassword = scanner.nextLine();
//                         System.out.println("Please enter the email of the admin:");
//                         String email = scanner.nextLine();
//                         admin.setEmail(email);
//                         admin.setRole("admin");
                        
//                         if(adminService.exists(adminUserName))
//                             System.out.println("User with that username already exists!");
//                         else
//                             adminService.createAdmin(admin);

//                     }else{
                        // Customer customer = new Customer();
                        // System.out.println("Please enter the username of the customer:");
                        // String customerUserName = scanner.nextLine();
                        // customer.setUserName(customerUserName);
                        // System.out.println("Please enter the password of the customer:");
                        // String customerPassword = scanner.nextLine();
                        // customer.setPassword(customerPassword);
                        // System.out.println("Please enter the email of the customer:");
                        // String email = scanner.nextLine();
                        // customer.setEmail(email);
                        // customer.setRole("customer");
                        // System.out.println("Please enter the first name of the customer:");
                        // String firstName = scanner.nextLine();
                        // customer.setFirstName(firstName);
                        // System.out.println("Please enter the last name of the customer:");
                        // String lastName = scanner.nextLine();
                        // customer.setLastName(lastName);
                        // System.out.println("Please enter the date of birth of the customer:");
                        // String dateOfBirth = scanner.nextLine();
                        // customer.setDateOfBirth(formatter.parse(dateOfBirth));
                        // System.out.println("Proceed to enter the address details of the customer:\nPlease enter the street:");
                        // String streetAddress = scanner.nextLine();
                        // System.out.println("Please enter the city:");
                        // String city = scanner.nextLine();
                        // System.out.println("Please enter the country:");
                        // String country = scanner.nextLine();
                        // System.out.println("Please enter the zip code:");
                        // int postalCode = scanner.nextInt();
                        // Address address = new Address();
                        // address.setStreetAddress(streetAddress);
                        // address.setCity(city);
                        // address.setCountry(country);
                        // address.setPostalCode(postalCode);

                        
                        // if(addressService.getAddressByStreetAddress(streetAddress) == null){
                        //     addressService.createAddress(address);
                        // }
                        
                        // customer.setCurrentResidence(address);
                        // customerService.createCustomer(customer);
                        // System.out.println("Customer created successfully!");

//                     }
//                     break;

//                     case 2:

//                     System.out.println("List of all users:");
//                     break;

//                     case 3:
//                     System.out.println("Enter the name of user you want to delete:");
                    
//                  name = scanner.nextLine();

//                if(adminService.exists(name)){

//                 if(adminService.deleteAdmin(name))
//                     System.out.println("Successfully deleteed!!");
//                 else
//                     System.out.println("There is some error in deleting the admin...");
//                 }else if(customerService.customerExists(name)){
//                     if(customerService.deleteCustomer(name))
//                         System.out.println("Successfully deleted a customer!");
//                     else
//                         System.out.println("There is some error in deleting the customer...");
            
//                 }

//                 }
//                 case 2:
//                     System.out.println("Welcome to product catalog! "+ userName);

//                     System.out.println("Enter \n1 to enter a new product \n2 to get a list of all products \n3 to delete a specific product.");
    
//                     int input = scanner.nextInt();
//                     scanner.nextLine();
    
//                     switch (input) {
//                         case 1:
                        
                    //     Product product = new Product();
                    //     System.out.println("Enter the name of the product:");
                    //     String name = scanner.nextLine();
                    //     product.setProductName(name);
    
                    //     System.out.println("Enter the price of the product:");
                    //     double price = scanner.nextDouble();
                    //     product.setPrice(price);
                    //     scanner.nextLine();
    
                    //     System.out.println("Enter the release date of the product:");
                    //     String releaseDate = scanner.nextLine();
                    //     product.setReleaseDate(formatter.parse(releaseDate));
                        
    
                    //     System.out.println("Enter the availability date of the product:");
                    //     String availabilityDate = scanner.nextLine();
                    //     product.setAvailabilityDate(formatter.parse(availabilityDate));
    
                    //     System.out.println("Enter the quantity of the product:");
                    //     int quantity = scanner.nextInt();
                    //     product.setQuantity(quantity);
    
                    //    product.setAdmin(adminService.getAdminByUserName(userName));
                    //    product.setOrderProducts(null);
    
                    //    if(productService.getProductByProductName(name) != null){
                    //        System.out.println("Product with that name already exists!");
                    //    }
                    //      else{
                    //         productService.createProduct(product);
                    //         System.out.println("Product created successfully!");
                    //      }
                        
    
//                         case 2:
    
//                         System.out.println("List of all products:");
//                         break;
//                 case 3:

               
//                 break;
//             }

                    
//                 }

//                 break;
//             case 2:
                

//             System.out.println("List of all users:");
    
//             System.out.println(adminService.exportAdmins());


//                 break;
//             case 3:

//                 System.out.println("Welcome to exporting a list of all order in CVS format!");
//                 break;
//             }

//         } else if(customerService.customerExists(userName, password)){

//             while(!customerService.customerExists(userName, password)){
//                 System.out.println("Invalid username or password. Please try again.");
//                 System.out.println("Please enter your username:");
//                 userName = scanner.nextLine();
//                 System.out.println("Please enter your password:");
//                 password = scanner.nextLine();
//             }

//             System.out.println("Welcome " + userName);

//             Customer currentCustomer = customerService.getCustomerByUserName(userName);

//             System.out.println("Enter \n 1 for getting a JSON format of your previous orders \n 2 for starting a new order");
            
//             int customerChoice = scanner.nextInt();
//             scanner.nextLine();

//             switch (customerChoice) {

//                 case 1:
//                     System.out.println("Welcome to exporting a list of all orders for current customer in JSON format!");
//                     // List<Order> orders = orderService.getOrdersByCustomer(currentCustomer.getID());


//                 break;

//                 case 2:
                    
//             List<Long> productIDs = new ArrayList<>();
//             List<Integer> quantities = new ArrayList<>();

//             System.out.println("Please enter the name of the product you want to order:");
//             String productName = scanner.nextLine();
//             productIDs.add(productService.getProductByProductName(productName).getProductID());

//             System.out.println("Please enter the amount of the product you want to order:");
//             int quantity = scanner.nextInt();
//             quantities.add(quantity);

//             scanner.nextLine();


//             System.out.println("Are you done with your order? y/n?");

//             String done = scanner.nextLine();

//             while(!done.equals("y")){
//                 System.out.println("Please enter the name of the product you want to order:");
//                 productName = scanner.nextLine();
//                 productIDs.add(productService.getProductByProductName(productName).getProductID());

//                 System.out.println("Please enter the amount of the product you want to order:");
//                 quantity = scanner.nextInt();
//                 quantities.add(quantity);

//                 scanner.nextLine();


//                 System.out.println("Are you done with your order? y/n?");
//                 done = scanner.nextLine();
//             }
            
//             System.out.println("Are you sure you want to place the order? y/n?");
//             String confirm = scanner.nextLine();

//             if(confirm.equals("y")){
//                 Order order = orderService.createOrderForCustomer(currentCustomer.getID(), productIDs,quantities);
//                 // List<Order> orders = orderService.getOrdersByCustomer(currentCustomer.getID());

//                 System.out.println("\n Order details:");
//                 int total = 0;
//                 // for (Order order : orders) {
//                 orderProductService.getOrderProductsByOrderId(order.getOrderID()).forEach(
                    
//                 x -> System.out.println("\n Product name:  "+x.getProduct().getProductName() + " Quantity: " + x.getQuantity() + " Total price for this product:  " + x.getPrice() +
//                 " Single product price: " +  (x.getPrice()/x.getQuantity()) + "\n")
//                 );
//                 List<OrderProduct> ordersProducts = orderProductService.getOrderProductsByOrderId(order.getOrderID());
//                     for(OrderProduct x: ordersProducts){
//                         total += x.getPrice();
//                     }
//                     System.out.println("Total price: "+total);
//                 // }
                
//             }else{
//                 System.out.println("Order not placed!");
//             }
            
//             break;
            
               
//             }


//         } else{
//             System.out.println("Invalid username or password");
//         }
    
        
        
//     }

// }
    

