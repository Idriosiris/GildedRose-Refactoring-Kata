package com.gildedrose.items;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public Sulfuras update() {
        return new Sulfuras(sellIn, quality);
    }
}
