package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose gildedRose(SimpleItem[] simpleItem) {
        return new GildedRose(simpleItem);
    }

    private SimpleItem[] withItems(SimpleItem... simpleItem) {
        return simpleItem;
    }

    @Test
    void foo() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("foo", 0, 0))
        );

        app.updateQuality();

        assertEquals("foo", app.simpleItems[0].name);
    }

    @Test
    void decrementQualityAndSellInAfterOneDay() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("item", 10, 10)
        ));

        app.updateQuality();

        assertEquals(9, app.simpleItems[0].quality);
        assertEquals(9, app.simpleItems[0].sellIn);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceTheSellByDateHasPassed() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("item", 0, 10)
        ));

        app.updateQuality();

        assertEquals(8, app.simpleItems[0].quality);
        assertEquals(-1, app.simpleItems[0].sellIn);
    }

    @Test
    void TestThatQualityIsNeverNegative() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("item", 0, 1)
        ));

        app.updateQuality();

        assertEquals(0, app.simpleItems[0].quality);
        assertEquals(-1, app.simpleItems[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Aged Brie", 10, 10)
        ));

        app.updateQuality();

        assertEquals(11, app.simpleItems[0].quality);
        assertEquals(9, app.simpleItems[0].sellIn);
    }

    @Test
    void agedBrieDoublesInQualityWhenSellinDayPasses() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Aged Brie", 0, 10)
        ));

        app.updateQuality();

        assertEquals(12, app.simpleItems[0].quality);
        assertEquals(-1, app.simpleItems[0].sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Aged Brie", 0, 50)
        ));

        app.updateQuality();

        assertEquals(50, app.simpleItems[0].quality);
    }

    @Test
    void sulfurasNeverDecreasesInQuality() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Sulfuras, Hand of Ragnaros", 2, 10)
        ));

        app.updateQuality();

        assertEquals(10, app.simpleItems[0].quality);
    }

    @Test
    void sulfurasSellinDayNeverDecreases() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Sulfuras, Hand of Ragnaros", 2, 10)
        ));

        app.updateQuality();

        assertEquals(2, app.simpleItems[0].sellIn);
    }

    @Test
    void backstagePassesIncreaseInQuality() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 15, 10)
        ));

        app.updateQuality();

        assertEquals(11, app.simpleItems[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByTwoIfSellInIsLowerThen10() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 10, 10)
        ));

        app.updateQuality();

        assertEquals(12, app.simpleItems[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByThreeIfSellInIsLowerThen5() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        ));

        app.updateQuality();

        assertEquals(13, app.simpleItems[0].quality);
    }

    @Test
    void backstagePassesDropsTo0AfterConcert() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        ));

        app.updateQuality();

        assertEquals(0, app.simpleItems[0].quality);
    }
}
