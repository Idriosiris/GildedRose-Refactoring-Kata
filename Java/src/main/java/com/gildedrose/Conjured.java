package com.gildedrose;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    public void updateQualityAndSellIn() {
        if (quality > 0) {
            decreaseQuality();
            decreaseQuality();
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0) {
            decreaseQuality();
            decreaseQuality();
        }
    }
}
