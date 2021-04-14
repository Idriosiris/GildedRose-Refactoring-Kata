package com.gildedrose.items;

public class SimpleItem extends Item {

    public SimpleItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality > 0) {
            decreaseQuality(1);
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0) {
            decreaseQuality(1);
        }
    }

}
