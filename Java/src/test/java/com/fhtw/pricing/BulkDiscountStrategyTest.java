package com.fhtw.pricing;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fhtw.core.Item;

class BulkDiscountStrategyTest {

    private BulkDiscountStrategy bulkDiscountStrategy;

    @BeforeEach
    void setUp() {
        bulkDiscountStrategy = new BulkDiscountStrategy();
    }

    @Test
    void testCalculatePriceWithoutDiscount() {
        Item item = new Item("Test Item", 10, 5, 20.0, 5);
        double expectedPrice = 20.0 * 5;
        double actualPrice = bulkDiscountStrategy.calculatePrice(item);
        assertEquals(expectedPrice, actualPrice, "Price should be calculated without discount.");
    }

    @Test
    void testCalculatePriceWithDiscount() {
        Item item = new Item("Test Item", 10, 5, 20.0, 15);
        double expectedPrice = 20.0 * 15 * 0.9; // Applying the discount rate
        double actualPrice = bulkDiscountStrategy.calculatePrice(item);
        assertEquals(expectedPrice, actualPrice, "Price should be calculated with bulk discount.");
    }

    @Test
    void testCalculatePriceAtDiscountThreshold() {
        Item item = new Item("Test Item", 10, 5, 20.0, 10);
        double expectedPrice = 20.0 * 10 * 0.9; // Applying the discount rate
        double actualPrice = bulkDiscountStrategy.calculatePrice(item);
        assertEquals(expectedPrice, actualPrice, "Price should be calculated with bulk discount at the threshold.");
    }
}

