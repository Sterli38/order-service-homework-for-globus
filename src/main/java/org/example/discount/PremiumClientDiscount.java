package org.example.discount;

import org.example.model.Order;

public class PremiumClientDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getAmount() * 0.10;
    }
}
