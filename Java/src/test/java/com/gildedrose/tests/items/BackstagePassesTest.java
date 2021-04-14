package com.gildedrose.tests.items;

import com.gildedrose.BackstagePasses;
import com.gildedrose.GildedRoseShop;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {
    private GildedRoseShop app;

    private GildedRoseShop gildedRose(Item[] item) {
        return new GildedRoseShop(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void backstagePassesIncreaseInQuality() {
        app = gildedRose(withItems(
                new BackstagePasses(15, 10)
        ));

        app.update();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByTwoIfSellInIsLowerThen10() {
        app = gildedRose(withItems(
                new BackstagePasses(10, 10)
        ));

        app.update();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByThreeIfSellInIsLowerThen5() {
        app = gildedRose(withItems(
                new BackstagePasses(5, 10)
        ));

        app.update();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    void backstagePassesDropsTo0AfterConcert() {
        app = gildedRose(withItems(
                new BackstagePasses(0, 10)
        ));

        app.update();

        assertEquals(0, app.items[0].quality);
    }
}
