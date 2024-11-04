package com.fhtw.quality;

import com.fhtw.core.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineQualityStrategyTest {

    private DeadlineQualityStrategy deadlineQualityStrategy;

    @BeforeEach
    void setUp() {
        deadlineQualityStrategy = new DeadlineQualityStrategy();
    }

    @Test
    void updateMoreThanTenDaysLeft() {
        Item item = new Item("Deadline Item", 10, 15, 20.0, 1);
        deadlineQualityStrategy.update(item);
        assertEquals(14, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(11, item.getQuality(), "Quality should increase by 1 when more than 10 days left.");
    }


    @Test
    void updateBetweenSixAndTenDaysLeft() {
        Item item = new Item("Deadline Item", 10, 8, 20.0, 1);
        deadlineQualityStrategy.update(item);
        assertEquals(7, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(12, item.getQuality(), "Quality should increase by 2 when between 6 and 10 days left.");
    }

    @Test
    void updateBetweenOneAndFiveDaysLeft() {
        Item item = new Item("Deadline Item", 10, 4, 20.0, 1);
        deadlineQualityStrategy.update(item);
        assertEquals(3, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(13, item.getQuality(), "Quality should increase by 3 when between 1 and 5 days left.");
    }

    @Test
    void updateOnSellDate() {
        Item item = new Item("Deadline Item", 10, 0, 20.0, 1);
        deadlineQualityStrategy.update(item);
        assertEquals(-1, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(0, item.getQuality(), "Quality should drop to 0 on the sell date.");
    }

    @Test
    void updateAfterSellDate() {
        Item item = new Item("Deadline Item", 10, -1, 20.0, 1);
        deadlineQualityStrategy.update(item);
        assertEquals(-2, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(0, item.getQuality(), "Quality should remain 0 after the sell date.");
    }

    @Test
    void updateQualityDoesNotExceedMax() {
        Item item = new Item("Deadline Item", 49, 4, 20.0, 1);
        deadlineQualityStrategy.update(item);
        assertEquals(3, item.getSellIn(), "SellIn should decrease by one.");
        assertEquals(Item.MAX_QUALITY, item.getQuality(), "Quality should not exceed MAX_QUALITY.");
    }
}
