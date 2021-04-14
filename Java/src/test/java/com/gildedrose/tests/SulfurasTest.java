package com.gildedrose.tests;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.Sulfuras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    private GildedRose app;

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void sulfurasNeverDecreasesInQuality() {
        app = gildedRose(withItems(
                new Sulfuras(2, 10)
        ));

        app.updateQuality();

        assertEquals(10, app.items[0].quality);
    }

    @Test
    void sulfurasSellinDayNeverDecreases() {
        app = gildedRose(withItems(
                new Sulfuras(2, 10)
        ));

        app.updateQuality();

        assertEquals(2, app.items[0].sellIn);
    }
}
