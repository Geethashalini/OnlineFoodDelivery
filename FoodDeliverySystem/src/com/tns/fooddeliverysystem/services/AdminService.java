package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private Map<Integer, Restaurant> restaurants = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();
    private Map<Integer, DeliveryPerson> deliveryPersons = new HashMap<>();

    // Add restaurant
    public void addRestaurant(int restaurantId, String name) {
        Restaurant restaurant = new Restaurant(restaurantId, name);
        restaurants.put(restaurantId, restaurant);
        System.out.println("Restaurant added successfully!");
    }

    // Add food item to a restaurant
    public void addFoodItemToRestaurant(int restaurantId, int foodItemId, String foodName, double price) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant != null) {
            FoodItem foodItem = new FoodItem(foodItemId, foodName, price);
            restaurant.addFoodItem(foodItem);
            System.out.println("Food item added successfully!");
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    // View restaurants and their menus
    public void viewRestaurantsAndMenus() {
        for (Restaurant restaurant : restaurants.values()) {
            System.out.println(restaurant.toString());
        }
    }

    // Add delivery person
    public void addDeliveryPerson(int deliveryPersonId, String name, long contactNo) {
        DeliveryPerson deliveryPerson = new DeliveryPerson(deliveryPersonId, name, contactNo);
        deliveryPersons.put(deliveryPersonId, deliveryPerson);
        System.out.println("Delivery person added successfully!");
    }

    // Assign delivery person to an order
    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        Order order = orders.get(orderId);
        DeliveryPerson deliveryPerson = deliveryPersons.get(deliveryPersonId);
        if (order != null && deliveryPerson != null) {
            order.assignDeliveryPerson(deliveryPerson);
            System.out.println("Delivery person assigned to order successfully!");
        } else {
            System.out.println("Order or Delivery Person not found.");
        }
    }

    // View orders
//    public void viewOrders() {
//        for (Order order : orders.values()) {
//            System.out.println(order.toString());
//        }
//    }
//    public void viewOrders() {
//        if (orders.isEmpty()) {
//            System.out.println("No orders available.");
//        } else {
//            for (Order order : orders.values()) {
//                System.out.println(order.toString());
//            }
//        }
//    }
    // View orders (including customer-specific view)
    public void viewOrders(int customerId) {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            if (customerId == 0) {
                System.out.println("All Orders:");
                for (Order order : orders.values()) {
                    System.out.println(order.toString());
                }
            } else {
                System.out.println("Orders for Customer " + customerId + ":");
                for (Order order : orders.values()) {
                    if (order.getCustomer().getUserId() == customerId) {
                        System.out.println(order.toString());
                    }
                }
            }
        }
    }
    
 // Remove food item from a restaurant
    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodItemId);
            System.out.println("Food item removed successfully!");
        } else {
            System.out.println("Restaurant not found.");
        }
    }
    
    private List<FoodItem> restaurantMenu = new ArrayList<>();
    private List<FoodItem> foodMenu;
    public AdminService() {
    	this.foodMenu = new ArrayList<>();  // Initialize the list
        // Sample data to populate the menu
        foodMenu.add(new FoodItem(1, "Pizza", 150.0));
        foodMenu.add(new FoodItem(2, "Burger", 100.0));
        foodMenu.add(new FoodItem(3, "Pasta", 200.0));
    }

    // Method to get food item by ID from the restaurant menu
    public FoodItem getFoodItemById(int foodItemId) {
        for (FoodItem foodItem : restaurantMenu) {
            if (foodItem.getId() == foodItemId) {
                return foodItem;
            }
        }
        return null; // Return null if the food item is not found
    }
    
    // Method to get the full menu (optional)
    public List<FoodItem> getFoodMenu() {
        return foodMenu;
    }

 // New method to get all available food items
    public List<FoodItem> getAvailableFoodItems() {
        List<FoodItem> availableFoodItems = new ArrayList<>();
        for (Restaurant restaurant : restaurants.values()) {
            availableFoodItems.addAll(restaurant.getMenu());
        }
        return availableFoodItems;
    }

    // Set the list of orders for admin actions
    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

	public void viewOrders() {
		// TODO Auto-generated method stub
		
	}
}

