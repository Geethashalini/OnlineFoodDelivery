package com.tns.fooddeliverysystem.entities;

import java.util.Map;

public class Order {
    private int orderId;
    private int customerId;
    private Map<FoodItem, Integer> orderedItems;
    private DeliveryPerson deliveryPerson; // Add this field to store the assigned delivery person

    public Order(int orderId, int customerId, Map<FoodItem, Integer> orderedItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderedItems = orderedItems;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Map<FoodItem, Integer> getOrderedItems() {
        return orderedItems;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    // Method to assign a delivery person to the order
    public void assignDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer ID: ").append(customerId).append("\n");
        sb.append("Ordered Items:\n");
        for (Map.Entry<FoodItem, Integer> entry : orderedItems.entrySet()) {
            sb.append(entry.getKey().getName()).append(" - Quantity: ").append(entry.getValue()).append("\n");
        }
        if (deliveryPerson != null) {
            sb.append("Assigned Delivery Person: ").append(deliveryPerson.getName()).append("\n");
        } else {
            sb.append("No delivery person assigned yet.\n");
        }
        return sb.toString();
    }
}
