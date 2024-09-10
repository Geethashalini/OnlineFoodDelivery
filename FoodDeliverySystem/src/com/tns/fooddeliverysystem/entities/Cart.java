package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;

    // Constructor
    public Cart() {
        items = new HashMap<>();
    }

    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, quantity);
    }

    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder cartContents = new StringBuilder();
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            cartContents.append("Food Item: ").append(entry.getKey().getName())
                    .append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        return cartContents.toString();
    }
}
