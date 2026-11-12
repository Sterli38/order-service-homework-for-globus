package org.example.commission;

import org.example.model.Order;

public class CashCommission implements CommissionStrategy {
    @Override
    public double calculateCommission(Order order) {
        return 0.0;
    }
}
