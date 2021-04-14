package com.gildedrose.items;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    public void update() {
        if (quality > 0) {
            decreaseQuality(2);
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0) {
            decreaseQuality(2);
        }
    }
}