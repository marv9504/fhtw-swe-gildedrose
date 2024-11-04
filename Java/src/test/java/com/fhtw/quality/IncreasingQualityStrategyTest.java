package com.fhtw.quality;

import com.fhtw.core.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncreasingQualityStrategyTest {

    private IncreasingQualityStrategy increasingQualityStrategy;

    @BeforeEach
    void setUp() {
        increasingQualityStrategy = new IncreasingQualityStrategy();
    }

    @Test
    void updateBeforeSellDate() {
        Item item = new Item("Aged Brie", 10, 5, 20.0, 1);
        increasingQualityStrategy.update(item);
        assertEquals(4, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(11, item.getQuality(), "Quality should increase by 1 before the sell date.");
    }

    @Test
    void updateOnSellDate() {
        Item item = new Item("Aged Brie", 10, 0, 20.0, 1);
        increasingQualityStrategy.update(item);
        assertEquals(-1, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(12, item.getQuality(), "Quality should increase by 2 on the sell date.");
    }

    @Test
    void updateAfterSellDate() {
        Item item = new Item("Aged Brie", 10, -1, 20.0, 1);
        increasingQualityStrategy.update(item);
        assertEquals(-2, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(12, item.getQuality(), "Quality should increase by 2 after the sell date.");
    }

    @Test
    void updateQualityDoesNotExceedMax() {
        Item item = new Item("Aged Brie", 49, 5, 20.0, 1);
        increasingQualityStrategy.update(item);
        assertEquals(4, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(Item.MAX_QUALITY, item.getQuality(), "Quality should not exceed the maximum quality limit.");
    }
}
