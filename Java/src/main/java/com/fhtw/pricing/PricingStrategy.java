package com.fhtw.pricing;

import com.fhtw.core.Item;

public interface PricingStrategy {

    double calculatePrice(Item item);
}

