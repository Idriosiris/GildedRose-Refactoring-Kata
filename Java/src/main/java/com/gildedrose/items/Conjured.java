package com.gildedrose.items;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    public Conjured update() {
        if (quality > 0) {
            decreaseQuality(2);
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0) {
            decreaseQuality(2);
        }

        return new Conjured(sellIn, quality);
    }
}
