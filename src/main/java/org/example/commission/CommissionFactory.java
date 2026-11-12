package org.example.commission;

import java.util.HashMap;
import java.util.Map;

public class CommissionFactory {
    private final Map<String, CommissionStrategy> strategyMap = new HashMap<>();

    public CommissionFactory() {
        strategyMap.put("CARD", new CardCommission());
        strategyMap.put("TRANSFER", new TransferCommission());
        strategyMap.put("CASH", new CashCommission());
    }

    public CommissionStrategy getCommissionStrategy(String paymentType) {
        CommissionStrategy commissionStrategy = strategyMap.get(paymentType);
        if (commissionStrategy == null) {
            throw new RuntimeException("Unknown payment type: " + paymentType);
        }
        return commissionStrategy;
    }
}
