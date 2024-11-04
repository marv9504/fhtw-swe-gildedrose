package com.fhtw;

import com.fhtw.core.Item;
import com.fhtw.quality.*;

public class TestMain {

    public static void main(String[] args) {
        testDefaultQualityStrategy();
        testDeadlineQualityStrategy();
        testIncreasingQualityStrategy();
        testConjuredQualityStrategy();
        testLegendaryQualityStrategy();
    }

    private static void testDefaultQualityStrategy() {
        System.out.println("Testing DefaultQualityStrategy:");
        Item item = new Item("Standard Item", 10, 5, 20.0, 1);
        DefaultQualityStrategy strategy = new DefaultQualityStrategy();
        System.out.println("Before update: " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));
        System.out.println();
    }

    private static void testDeadlineQualityStrategy() {
        System.out.println("Testing DeadlineQualityStrategy:");
        Item item = new Item("Backstage Pass", 10, 11, 20.0, 1); // Test before deadline
        DeadlineQualityStrategy strategy = new DeadlineQualityStrategy();

        System.out.println("Before update (more than 10 days): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Backstage Pass", 10, 8, 20.0, 1); // Test between 6 and 10 days
        System.out.println("\nBefore update (between 6-10 days): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Backstage Pass", 10, 4, 20.0, 1); // Test between 1 and 5 days
        System.out.println("\nBefore update (between 1-5 days): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Backstage Pass", 10, 0, 20.0, 1); // Test on deadline day
        System.out.println("\nBefore update (on deadline day): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Backstage Pass", 10, -1, 20.0, 1); // Test after deadline
        System.out.println("\nBefore update (after deadline): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));
        System.out.println();
    }

    private static void testIncreasingQualityStrategy() {
        System.out.println("Testing IncreasingQualityStrategy:");
        Item item = new Item("Aged Brie", 10, 5, 20.0, 1);
        IncreasingQualityStrategy strategy = new IncreasingQualityStrategy();

        System.out.println("Before update (before sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Aged Brie", 10, 0, 20.0, 1);
        System.out.println("\nBefore update (on sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Aged Brie", 10, -1, 20.0, 1);
        System.out.println("\nBefore update (after sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));
        System.out.println();
    }

    private static void testConjuredQualityStrategy() {
        System.out.println("Testing ConjuredQualityStrategy:");
        Item item = new Item("Conjured Mana Cake", 10, 5, 20.0, 1);
        ConjuredQualityStrategy strategy = new ConjuredQualityStrategy();

        System.out.println("Before update (before sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Conjured Mana Cake", 10, 0, 20.0, 1);
        System.out.println("\nBefore update (on sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Conjured Mana Cake", 10, -1, 20.0, 1);
        System.out.println("\nBefore update (after sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));
        System.out.println();
    }

    private static void testLegendaryQualityStrategy() {
        System.out.println("Testing LegendaryQualityStrategy:");
        Item item = new Item("Sulfuras, Hand of Ragnaros", 80, 10, 0.0, 1);
        LegendaryQualityStrategy strategy = new LegendaryQualityStrategy();

        System.out.println("Before update: " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));

        item = new Item("Sulfuras, Hand of Ragnaros", 80, -1, 0.0, 1);
        System.out.println("\nBefore update (after sell date): " + itemDetails(item));
        strategy.update(item);
        System.out.println("After update: " + itemDetails(item));
        System.out.println();
    }

    private static String itemDetails(Item item) {
        return String.format("Item[name=%s, quality=%d, sellIn=%d, price=%.2f, quantity=%d]",
            item.getName(), item.getQuality(), item.getSellIn(), item.getPrice(), item.getQuantity());
    }
}
