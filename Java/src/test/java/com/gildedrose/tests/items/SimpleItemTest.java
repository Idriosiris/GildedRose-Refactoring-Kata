package com.gildedrose.tests.items;

import com.gildedrose.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleItemTest {

    private GildedRose app;

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void foo() {
        app = gildedRose(withItems(
                new SimpleItem("foo", 0, 0))
        );

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    @Test
    void decrementQualityAndSellInAfterOneDay() {
        app = gildedRose(withItems(
                new SimpleItem("item", 10, 10)
        ));

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceTheSellByDateHasPassed() {
        app = gildedRose(withItems(
                new SimpleItem("item", 0, 10)
        ));

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void TestThatQualityIsNeverNegative() {
        app = gildedRose(withItems(
                new SimpleItem("item", 0, 1)
        ));

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
