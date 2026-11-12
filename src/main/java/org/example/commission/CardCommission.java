package org.example.commission;

import org.example.model.Order;

public class CardCommission implements CommissionStrategy {
    @Override
    public double calculateCommission(Order order) {
        return order.getAmount() * 0.02;
    }
}
