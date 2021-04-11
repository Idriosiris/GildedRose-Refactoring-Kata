package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void foo() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("foo", 0, 0))
        );

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    @Test
    void decrementQualityAndSellInAfterOneDay() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("item", 10, 10)
        ));

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceTheSellByDateHasPassed() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("item", 0, 10)
        ));

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void TestThatQualityIsNeverNegative() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("item", 0, 1)
        ));

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        GildedRose app = gildedRose(withItems(
                new AgedBrie( 10, 10)
        ));

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void agedBrieDoublesInQualityWhenSellinDayPasses() {
        GildedRose app = gildedRose(withItems(
                new AgedBrie( 0, 10)
        ));

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        GildedRose app = gildedRose(withItems(
                new AgedBrie( 0, 50)
        ));

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurasNeverDecreasesInQuality() {
        GildedRose app = gildedRose(withItems(
                new Sulfuras( 2, 10)
        ));

        app.updateQuality();

        assertEquals(10, app.items[0].quality);
    }

    @Test
    void sulfurasSellinDayNeverDecreases() {
        GildedRose app = gildedRose(withItems(
                new Sulfuras( 2, 10)
        ));

        app.updateQuality();

        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void backstagePassesIncreaseInQuality() {
        GildedRose app = gildedRose(withItems(
                new BackstagePasses( 15, 10)
        ));

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByTwoIfSellInIsLowerThen10() {
        GildedRose app = gildedRose(withItems(
                new BackstagePasses(10, 10)
        ));

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByThreeIfSellInIsLowerThen5() {
        GildedRose app = gildedRose(withItems(
                new BackstagePasses(5, 10)
        ));

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    void backstagePassesDropsTo0AfterConcert() {
        GildedRose app = gildedRose(withItems(
                new BackstagePasses(0, 10)
        ));

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    void conjuredItemsDegradeTwiceAsFastAsSimpleItems() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Simple",4, 10),
                new Conjured(4, 10)
        ));

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }

    void conjuredItemsDegradeTwiceAsFastAsSimpleItemsAlsoWhenSellInIs0() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Simple",0, 10),
                new Conjured(0, 10)
        ));

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
    }
}
