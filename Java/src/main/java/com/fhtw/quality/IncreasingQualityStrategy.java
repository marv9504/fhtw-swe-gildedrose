package com.fhtw.quality;

import com.fhtw.core.Item;

public class IncreasingQualityStrategy implements QualityStrategy {

    @Override
    public void update(Item item) {

        item.decreaseSellInByOne();
        item.increaseQualityBy(1);

        if (item.getSellIn() < 0) {
            item.increaseQualityBy(1);
        }
    }
}
