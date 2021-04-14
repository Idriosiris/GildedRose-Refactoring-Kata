package com.gildedrose;

import com.gildedrose.items.Item;

public class GildedRoseShop {
    private Item[] items;

    public GildedRoseShop(Item[] items) {
        this.items = items;
    }

    public GildedRoseShop update() {
        for (Item item : items) {
            item.update();
        }

        return new GildedRoseShop(items);
    }

    public Item getItemFromShelfPosition(int position) {
        return items[position-1];
    }
}
