package com.gildedrose;

public class GildedRoseShop {
    public Item[] items;

    public GildedRoseShop(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            item.update();
        }
    }

}
