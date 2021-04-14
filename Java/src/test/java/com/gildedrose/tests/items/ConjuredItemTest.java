package com.gildedrose.tests.items;

import com.gildedrose.Conjured;
import com.gildedrose.GildedRoseShop;
import com.gildedrose.Item;
import com.gildedrose.SimpleItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private GildedRoseShop app;

    private GildedRoseShop gildedRose(Item[] item) {
        return new GildedRoseShop(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItems() {
        app = gildedRose(withItems(
                new SimpleItem("Simple", 4, 10),
                new Conjured(4, 10)
        ));

        app.update();

        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItemsAlsoWhenSellInIs0() {
        app = gildedRose(withItems(
                new SimpleItem("Simple", 0, 10),
                new Conjured(0, 10)
        ));

        app.update();

        assertEquals(8, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
    }
}
