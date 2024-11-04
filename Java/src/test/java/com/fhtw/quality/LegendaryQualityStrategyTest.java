package com.fhtw.quality;

import com.fhtw.core.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryQualityStrategyTest {

    private LegendaryQualityStrategy legendaryQualityStrategy;

    @BeforeEach
    void setUp() {
        legendaryQualityStrategy = new LegendaryQualityStrategy();
    }

    @Test
    void updateQualityAndSellInDoNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 80, 10, 0.0, 1);

        legendaryQualityStrategy.update(item);

        assertEquals(10, item.getSellIn(), "SellIn should remain unchanged for legendary items.");
        assertEquals(80, item.getQuality(), "Quality should remain unchanged for legendary items.");
    }

    @Test
    void updateQualityRemainsConstantAfterSellDate() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 80, -1, 0.0, 1);

        legendaryQualityStrategy.update(item);

        assertEquals(-1, item.getSellIn(), "SellIn should remain unchanged for legendary items.");
        assertEquals(80, item.getQuality(), "Quality should remain unchanged for legendary items.");
    }
}
