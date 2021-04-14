package com.gildedrose;

import com.gildedrose.items.Item;

public class GildedRoseShop {
    private Item[] items;

    public GildedRoseShop(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            item.update();
        }
    }

    public Item getItemFromShelfPosition(int position) {
        return items[position-1];
    }
}
