package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void decrementQualityAndSellInAfterOneDay() {
        Item[] items = new Item[] { new Item("item", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceTheSellByDateHasPassed() {
        Item[] items = new Item[] { new Item("item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void TestThatQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("item", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void agedBrieDoublesInQualityWhenSellinDayPasses() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
}
