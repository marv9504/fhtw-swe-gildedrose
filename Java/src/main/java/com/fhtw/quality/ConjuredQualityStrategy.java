package com.fhtw.quality;

import com.fhtw.core.Item;

public class ConjuredQualityStrategy implements QualityStrategy {

    @Override
    public void update(Item item) {
        item.decreaseSellInByOne();

        // Decrease twice as fast
        item.decreaseQualityByOne();
        item.decreaseQualityByOne();

        // Additional decrease after sell date
        if (item.getSellIn() < 0) {
            item.decreaseQualityByOne();
            item.decreaseQualityByOne();
        }
    }
}

