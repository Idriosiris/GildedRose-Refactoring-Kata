package com.gildedrose;

public class SimpleItem extends Item {

    public SimpleItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQualityAndSellIn() {
        if (quality > 0) {
            decreaseQuality();
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0) {
            decreaseQuality();
        }
    }

}
