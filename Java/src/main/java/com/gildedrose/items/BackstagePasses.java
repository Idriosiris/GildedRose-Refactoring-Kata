package com.gildedrose.items;

public class BackstagePasses extends Item {
    public BackstagePasses( int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public BackstagePasses update() {
        if (quality < 50) {
            incrementQuality();

            if (sellIn < 11 && quality < 50) {
                incrementQuality();
            }

            if (sellIn < 6 && quality < 50) {
                incrementQuality();
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }

        return new BackstagePasses(sellIn, quality);
    }
}
