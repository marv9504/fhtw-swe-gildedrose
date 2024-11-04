package com.fhtw.pricing;

import com.fhtw.core.Item;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Item item) {
        return item.getPrice() * item.getQuantity();
    }
}
