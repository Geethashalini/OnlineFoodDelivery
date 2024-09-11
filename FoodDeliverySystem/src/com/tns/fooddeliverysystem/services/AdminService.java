package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class AdminService {
    private Map<Integer, Restaurant> restaurants = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>(); // Initialize orders map
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
            restaurant.addFoodItem(new FoodItem(foodItemId, foodName, price));
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

    // View all orders
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (Order order : orders.values()) {
                System.out.println(order.toString());
            }
        }
    }

    // Set orders from CustomerService
    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }
}
