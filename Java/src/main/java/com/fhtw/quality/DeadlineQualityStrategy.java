package com.fhtw.quality;

import com.fhtw.core.Item;

public class DeadlineQualityStrategy implements QualityStrategy {

    public static final int QUALITY_RESET_THRESHOLD = 0;
    public static final int HIGH_QUALITY_THRESHOLD = 6;
    public static final int MEDIUM_QUALITY_THRESHOLD = 11;

    @Override
    public void update(Item item) {

        item.decreaseSellInByOne();

        if (item.getSellIn() < QUALITY_RESET_THRESHOLD) {
            // Reset quality after the concert date
            item.setQuality(0);
        }
        else if (item.getSellIn() < HIGH_QUALITY_THRESHOLD) {
            // Increase by 3 if less than 6 days
            item.increaseQualityBy(3);
        }
        else if (item.getSellIn() < MEDIUM_QUALITY_THRESHOLD) {
            // Increase by 2 if less than 11 days
            item.increaseQualityBy(2);
        }
        else {
            // Otherwise, increase by 1
            item.increaseQualityBy(1);
        }
    }
}
