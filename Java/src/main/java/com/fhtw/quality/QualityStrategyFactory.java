package com.fhtw.quality;


import com.fhtw.core.Item;

public class QualityStrategyFactory {
    public QualityStrategy getStrategy(Item item) {
        switch (item.getName()) {
            case "Aged Brie":
                return new IncreasingQualityStrategy();
            case "Backstage passes":
                return new DeadlineQualityStrategy();
            case "Sulfuras":
                return new LegendaryQualityStrategy();
            case "Conjured":
                return new ConjuredQualityStrategy();
            default:
                return new DefaultQualityStrategy();
        }
    }
}



