package com.gildedrose.items;

public abstract class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void decreaseQuality(int amount) {
        quality = quality - amount;
    }

    void incrementQuality() {
        quality = quality + 1;
    }

    public int quality(Item item) {
        return item.quality;
    }

    public int sellIn(Item item) {
        return item.sellIn;
    }

    public abstract Item update();

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
