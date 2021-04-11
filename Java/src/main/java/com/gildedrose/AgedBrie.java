package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality );
    }

    @Override
    public void updateQualityAndSellIn() {
        if (quality < 50) {
            incrementQuality();

        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                incrementQuality();
            }
        }
    }
}