package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses( int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQualityAndSellIn() {
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
    }
}
