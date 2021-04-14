package com.gildedrose.tests;

import com.gildedrose.BackstagePasses;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {
    private GildedRose app;

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void backstagePassesIncreaseInQuality() {
        app = gildedRose(withItems(
                new BackstagePasses(15, 10)
        ));

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByTwoIfSellInIsLowerThen10() {
        app = gildedRose(withItems(
                new BackstagePasses(10, 10)
        ));

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByThreeIfSellInIsLowerThen5() {
        app = gildedRose(withItems(
                new BackstagePasses(5, 10)
        ));

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    void backstagePassesDropsTo0AfterConcert() {
        app = gildedRose(withItems(
                new BackstagePasses(0, 10)
        ));

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }
}
