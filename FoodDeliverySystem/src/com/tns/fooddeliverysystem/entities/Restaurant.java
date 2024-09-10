package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu;

    // Constructor
    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    // Add and remove food items
    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int foodItemId) {
        menu.removeIf(foodItem -> foodItem.getId() == foodItemId);
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        StringBuilder restaurantInfo = new StringBuilder();
        restaurantInfo.append("Restaurant ID: ").append(id).append(", Name: ").append(name).append("\n");
        for (FoodItem foodItem : menu) {
            restaurantInfo.append("- ").append(foodItem.toString()).append("\n");
        }
        return restaurantInfo.toString();
    }
}
