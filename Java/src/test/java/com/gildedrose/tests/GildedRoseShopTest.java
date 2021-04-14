package com.gildedrose.tests;

import com.gildedrose.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GildedRoseShopTest {

    private GildedRoseShop gildedRoseShop;

    private GildedRoseShop gildedRose(Item[] item) {
        return new GildedRoseShop(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void gildedRoseShopUpdateUpdatesAllItemsSellIn() {
        gildedRoseShop = gildedRose(withItems(
                new Conjured( 5, 21),
                new AgedBrie(10, 12),
                new BackstagePasses(5, 7))
        );

        gildedRoseShop.update();

        assertNotEquals(5 , gildedRoseShop.items[0].quality);
        assertNotEquals(10, gildedRoseShop.items[1].quality);
        assertNotEquals(5 , gildedRoseShop.items[2].quality);

        assertNotEquals(21, gildedRoseShop.items[0].quality);
        assertNotEquals(12, gildedRoseShop.items[1].quality);
        assertNotEquals(7 , gildedRoseShop.items[2].quality);
    }
}
