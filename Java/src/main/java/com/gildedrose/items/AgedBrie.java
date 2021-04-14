package com.gildedrose.items;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality );
    }

    @Override
    public AgedBrie update() {
        if (quality < 50) {
            incrementQuality();
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality < 50) {
            incrementQuality();
        }

        return new AgedBrie(sellIn, quality);
    }
}
