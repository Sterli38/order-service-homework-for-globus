package org.example.discount;

import org.example.model.Order;

public class RegularClientDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return 0.0;
    }
}
