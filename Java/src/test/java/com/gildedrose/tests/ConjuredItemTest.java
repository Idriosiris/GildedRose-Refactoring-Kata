package com.gildedrose.tests;

import com.gildedrose.Conjured;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.SimpleItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private GildedRose app;

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
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

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItemsAlsoWhenSellInIs0() {
        app = gildedRose(withItems(
                new SimpleItem("Simple", 0, 10),
                new Conjured(0, 10)
        ));

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
    }
}
