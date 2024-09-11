package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Restaurant> restaurants;
    private Map<Integer, Order> orders = new HashMap<>();  // Maintain orders
    private Map<Integer, Map<FoodItem, Integer>> carts = new HashMap<>();  // Cart for each customer

    public CustomerService(Map<Integer, Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    // Add a customer
    public void addCustomer(int customerId, String name, long contactNo) {
        Customer customer = new Customer(customerId, name, contactNo);
        customers.put(customerId, customer);
        System.out.println("Customer added successfully!");
    }

    // Add food to a customer's cart
    public void addToCart(int customerId, FoodItem foodItem, int quantity) {
        Map<FoodItem, Integer> cart = carts.getOrDefault(customerId, new HashMap<>());
        cart.put(foodItem, quantity);
        carts.put(customerId, cart);
        System.out.println("Food item added to cart.");
    }

    // View a customer's cart
    public void viewCart(int customerId) {
        Map<FoodItem, Integer> cart = carts.get(customerId);
        if (cart != null && !cart.isEmpty()) {
            for (Map.Entry<FoodItem, Integer> entry : cart.entrySet()) {
                System.out.println("Item: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
            }
        } else {
            System.out.println("Cart is empty.");
        }
    }

    // Place an order for a customer
    public void placeOrder(int customerId) {
        Map<FoodItem, Integer> cart = carts.get(customerId);
        if (cart != null && !cart.isEmpty()) {
            Order order = new Order(orders.size() + 1, customerId, cart);
            orders.put(order.getOrderId(), order);
            carts.remove(customerId);  // Clear the cart after placing the order
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Cart is empty. Cannot place an order.");
        }
    }

    // View all available food items in all restaurants
    public void viewAllFoodItems() {
        for (Restaurant restaurant : restaurants.values()) {
            System.out.println("Restaurant: " + restaurant.getName());
            for (FoodItem foodItem : restaurant.getMenu()) {
                System.out.println(foodItem.toString());
            }
        }
    }

    // View orders for a customer
    public void viewOrders(int customerId) {
        boolean hasOrders = false;
        for (Order order : orders.values()) {
            if (order.getCustomerId() == customerId) {
                System.out.println(order.toString());
                hasOrders = true;
            }
        }
        if (!hasOrders) {
            System.out.println("No orders found for customer ID: " + customerId);
        }
    }

    // Method to get all orders (used by AdminService)
    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
