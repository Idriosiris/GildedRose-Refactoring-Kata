package com.gildedrose;

public class SimpleItem extends Item {

    public SimpleItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQualityAndSellIn() {
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQuality();
                }
            }
        } else {
            if (quality < 50) {
                incrementQuality();

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            incrementQuality();
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            incrementQuality();
                        }
                    }
                }
            }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality();
                        }
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    incrementQuality();
                }
            }
        }
    }

}
