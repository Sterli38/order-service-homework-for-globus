package org.example.repository;

import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }
}
