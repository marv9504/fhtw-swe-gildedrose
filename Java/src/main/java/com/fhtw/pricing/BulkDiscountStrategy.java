package com.fhtw.pricing;

import com.fhtw.core.Item;

public class BulkDiscountStrategy implements PricingStrategy {

    private static final int DISCOUNT_THRESHOLD = 10;
    private static final double DISCOUNT_RATE = 0.9;

    @Override
    public double calculatePrice(Item item) {
        if (item.getQuantity() >= DISCOUNT_THRESHOLD) {
            return item.getPrice() * item.getQuantity() * DISCOUNT_RATE;
        } else {
            return item.getPrice() * item.getQuantity();
        }
    }
}
