package org.example.discount;

import org.example.model.Order;

public interface DiscountStrategy {
    double calculateDiscount(Order order);
}
