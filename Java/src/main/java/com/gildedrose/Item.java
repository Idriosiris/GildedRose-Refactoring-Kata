package com.gildedrose;

public abstract class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void decreaseQuality() {
        quality = quality - 1;
    }

    void incrementQuality() {
        quality = quality + 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract void updateQualityAndSellIn();
}
