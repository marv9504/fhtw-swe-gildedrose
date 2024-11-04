package com.fhtw.quality;

import com.fhtw.core.Item;

public class LegendaryQualityStrategy implements QualityStrategy {

    @Override
    public void update(Item item) {
        // Legendary items do not change in quality or sellIn
    }
}
