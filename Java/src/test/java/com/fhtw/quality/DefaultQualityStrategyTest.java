package com.fhtw.quality;

import com.fhtw.core.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultQualityStrategyTest {

    private DefaultQualityStrategy defaultQualityStrategy;

    @BeforeEach
    void setUp() {
        defaultQualityStrategy = new DefaultQualityStrategy();
    }

    @Test
    void updateBeforeSellDate() {
        Item item = new Item("Standard Item", 10, 5, 20.0, 1);
        defaultQualityStrategy.update(item);
        assertEquals(4, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(9, item.getQuality(), "Quality should decrease by 1 before the sell date.");
    }

    @Test
    void updateOnSellDate() {
        Item item = new Item("Standard Item", 10, 0, 20.0, 1);
        defaultQualityStrategy.update(item);
        assertEquals(-1, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(8, item.getQuality(), "Quality should decrease by 2 on the sell date.");
    }

    @Test
    void updateAfterSellDate() {
        Item item = new Item("Standard Item", 10, -1, 20.0, 1);
        defaultQualityStrategy.update(item);
        assertEquals(-2, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(8, item.getQuality(), "Quality should decrease by 2 after the sell date.");
    }

    @Test
    void updateQualityDoesNotGoBelowMin() {
        Item item = new Item("Standard Item", 1, 5, 20.0, 1);
        defaultQualityStrategy.update(item);
        assertEquals(4, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(0, item.getQuality(), "Quality should not go below the minimum quality.");
    }
}

