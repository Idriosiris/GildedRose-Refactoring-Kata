package com.gildedrose.tests.items;

import com.gildedrose.AgedBrie;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    private GildedRose app;

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void agedBrieIncreasesInQuality() {
        app = gildedRose(withItems(
                new AgedBrie(10, 10)
        ));

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void agedBrieDoublesInQualityWhenSellinDayPasses() {
        app = gildedRose(withItems(
                new AgedBrie(0, 10)
        ));

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        app = gildedRose(withItems(
                new AgedBrie(0, 50)
        ));

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }
}
