package com.fhtw.quality;

import com.fhtw.core.Item;

public class DefaultQualityStrategy implements QualityStrategy {

    @Override
    public void update(Item item) {

        item.decreaseSellInByOne();
        item.decreaseQualityByOne();

        if (item.getSellIn() < 0) {
            item.decreaseQualityByOne();
        }
    }
}

