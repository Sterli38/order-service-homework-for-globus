package org.example.discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountFactory {
    private final Map<String, DiscountStrategy> strategyMap = new HashMap<>();

    public DiscountFactory() {
        strategyMap.put("VIP", new VipClientDiscount());
        strategyMap.put("REGULAR", new RegularClientDiscount());
        strategyMap.put("PREMIUM", new PremiumClientDiscount());
    }

    public DiscountStrategy getDiscountStrategy(String customerType) {
        DiscountStrategy discountStrategy = strategyMap.get(customerType);
        if (discountStrategy == null) {
            throw new RuntimeException("Unknown customer type: " + customerType);
        }
        return discountStrategy;
    }
}
