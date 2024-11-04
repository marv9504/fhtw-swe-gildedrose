package com.fhtw.quality;

import com.fhtw.core.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredQualityStrategyTest {

    private ConjuredQualityStrategy conjuredQualityStrategy;

    @BeforeEach
    void setUp() {
        conjuredQualityStrategy = new ConjuredQualityStrategy();
    }

    @Test
    void updateBeforeSellDate() {
        Item item = new Item("Conjured Item", 20, 5, 10.0, 1);
        conjuredQualityStrategy.update(item);
        assertEquals(4, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(18, item.getQuality(), "Quality should decrease by 2 before the sell date.");
    }

    @Test
    void updateOnSellDate() {
        Item item = new Item("Conjured Item", 10, 0, 10.0, 1);
        conjuredQualityStrategy.update(item);
        assertEquals(-1, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(6, item.getQuality(), "Quality should decrease by 4 on or after the sell date.");
    }

    @Test
    void updateAfterSellDate() {
        Item item = new Item("Conjured Item", 10, -1, 10.0, 1);
        conjuredQualityStrategy.update(item);
        assertEquals(-2, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(6, item.getQuality(), "Quality should decrease by 4 after the sell date.");
    }

    @Test
    void updateQualityDoesNotGoBelowMin() {
        Item item = new Item("Conjured Item", 1, -1, 10.0, 1);
        conjuredQualityStrategy.update(item);
        assertEquals(-2, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(Item.MIN_QUALITY, item.getQuality(), "Quality should not go below the minimum quality.");
    }
}
