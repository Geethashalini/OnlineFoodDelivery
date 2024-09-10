package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CustomerService {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();
    private int currentOrderId = 1;
	private AdminService adminService;
	
	public CustomerService(AdminService adminService) {
        this.adminService = adminService;
    }

    // Add customer
    public void addCustomer(int userId, String username, long contactNo) {
        Customer customer = new Customer(userId, username, contactNo);
        customers.put(userId, customer);
        System.out.println("Customer created successfully!");
    }

    // View customer's cart
    public void viewCart(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            System.out.println(customer.getCart().toString());
        } else {
            System.out.println("Customer not found.");
        }
    }

    // Add food item to cart
    public void addToCart(int customerId, FoodItem foodItem, int quantity) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            customer.getCart().addItem(foodItem, quantity);
            System.out.println("Food item added to cart!");
        } else {
            System.out.println("Customer not found.");
        }
    }
    // Method to get the AdminService
    public AdminService getAdminService() {
        return this.adminService;
    }

    
    // Place order
    public void placeOrder(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            Order order = new Order(currentOrderId++, customer);
            orders.put(order.getOrderId(), order);
            adminService.setOrders(orders);
            System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
        } else {
            System.out.println("Customer not found.");
        }
    }

    // View orders
    public void viewOrders(int customerId) {
        for (Order order : orders.values()) {
            if (order.getCustomer().getUserId() == customerId) {
                System.out.println(order.toString());
            }
        }
    }
    // Add available food items for the customer to view
    public void addAvailableFoodItem(FoodItem foodItem) {
        //availableFoodItems.put(foodItem.getId(), foodItem);
    }
//
//    // View available food items
//    public void viewFoodItems() {
//        System.out.println("Available Food Items:");
//        for (FoodItem foodItem : availableFoodItems.values()) {
//            System.out.println(foodItem.toString());
            
	         // New method to view available food items from AdminService
	            public void viewAvailableFoodItems() {
	                List<FoodItem> availableFoodItems = adminService.getAvailableFoodItems();
	                if (availableFoodItems.isEmpty()) {
	                    System.out.println("No food items available.");
	                } else {
	                    System.out.println("Available Food Items:");
	                    for (FoodItem foodItem : availableFoodItems) {
	                        System.out.println(foodItem);
	                    }
	                }
	            }

				
	        
        
    }

