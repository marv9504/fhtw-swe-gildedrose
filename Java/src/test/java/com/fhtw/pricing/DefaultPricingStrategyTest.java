package com.fhtw.pricing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import com.fhtw.core.Item;

class DefaultPricingStrategyTest {

    private DefaultPricingStrategy defaultPricingStrategy;

    @BeforeEach
    void setUp() {
        defaultPricingStrategy = new DefaultPricingStrategy();
    }

    @Test
    void calculatePrice() {
        Item item = new Item("Test Item", 10, 5, 15.0, 3);
        double expectedPrice = 15.0 * 3;
        double actualPrice = defaultPricingStrategy.calculatePrice(item);
        assertEquals(expectedPrice, actualPrice, "Price should be calculated without any discounts.");
    }
}
