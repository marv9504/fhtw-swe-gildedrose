package com.fhtw.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Test Item", 10, 5, 20.0, 3);
    }

    @Test
    void testDecreaseSellInByOne() {
        item.decreaseSellInByOne();
        assertEquals(4, item.getSellIn(), "SellIn should decrease by one.");
    }

    @Test
    void testIncreaseQualityByWithinLimits() {
        item.increaseQualityBy(5);
        assertEquals(15, item.getQuality(), "Quality should increase by the specified increment within limits.");
    }

    @Test
    void testIncreaseQualityByExceedingMax() {
        item.increaseQualityBy(45);
        assertEquals(Item.MAX_QUALITY, item.getQuality(), "Quality should not exceed MAX_QUALITY.");
    }

    @Test
    void testDecreaseQualityByOneWithinLimits() {
        item.decreaseQualityByOne();
        assertEquals(9, item.getQuality(), "Quality should decrease by one within limits.");
    }

    @Test
    void testDecreaseQualityByOneAtMinLimit() {
        item = new Item("Test Item", Item.MIN_QUALITY, 5, 20.0, 3);
        item.decreaseQualityByOne();
        assertEquals(Item.MIN_QUALITY, item.getQuality(), "Quality should not go below MIN_QUALITY.");
    }

    @Test
    void testSetAndGetPrice() {
        item.setPrice(25.0);
        assertEquals(25.0, item.getPrice(), "Price should be set and retrieved correctly.");
    }

    @Test
    void testSetAndGetQuantity() {
        item.setQuantity(5);
        assertEquals(5, item.getQuantity(), "Quantity should be set and retrieved correctly.");
    }
}

