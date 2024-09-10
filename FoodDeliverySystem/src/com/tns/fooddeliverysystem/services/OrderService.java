package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.Order;

import java.util.Map;

public class OrderService {
    private Map<Integer, Order> orders;

    // Constructor
    public OrderService(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    // Get orders
    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
