package com.tns.fooddeliverysystem.application;
import com.tns.fooddeliverysystem.entities.FoodItem;


import com.tns.fooddeliverysystem.services.AdminService;
import com.tns.fooddeliverysystem.services.CustomerService;
import java.util.Scanner;public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();
        CustomerService customerService = new CustomerService(adminService);

        while (true) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(scanner, adminService);
                    break;
                case 2:
                    customerMenu(scanner, customerService);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner, AdminService adminService) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. View Restaurants and Menus");
            System.out.println("4. Add Delivery Person");
            System.out.println("5. Exit Admin Menu");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = scanner.nextInt();
                    System.out.print("Enter Restaurant Name: ");
                    String restaurantName = scanner.next();
                    adminService.addRestaurant(restaurantId, restaurantName);
                    break;
                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    restaurantId = scanner.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int foodItemId = scanner.nextInt();
                    System.out.print("Enter Food Item Name: ");
                    String foodItemName = scanner.next();
                    System.out.print("Enter Food Item Price: ");
                    double price = scanner.nextDouble();
                    adminService.addFoodItemToRestaurant(restaurantId, foodItemId, foodItemName, price);
                    break;
                case 3:
                    adminService.viewRestaurantsAndMenus();
                    break;
                case 4:
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryPersonId = scanner.nextInt();
                    System.out.print("Enter Delivery Person Name: ");
                    String deliveryPersonName = scanner.next();
                    System.out.print("Enter Contact No: ");
                    long contactNo = scanner.nextLong();
                    adminService.addDeliveryPerson(deliveryPersonId, deliveryPersonName, contactNo);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void customerMenu(Scanner scanner, CustomerService customerService) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Food to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Exit Customer Menu");
            System.out.print("Choose an option: ");
            int customerChoice = scanner.nextInt();

            switch (customerChoice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter Contact No: ");
                    long contactNo = scanner.nextLong();
                    customerService.addCustomer(customerId, customerName, contactNo);
                    break;
                case 2:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int foodItemId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    // In a real application, the food item should be fetched from the admin's restaurant menu
                    FoodItem foodItem = new FoodItem(foodItemId, "Sample Food", 100.0);
                    customerService.addToCart(customerId, foodItem, quantity);
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextInt();
                    customerService.viewCart(customerId);
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    customerId = scanner.nextInt();
                    customerService.placeOrder(customerId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}