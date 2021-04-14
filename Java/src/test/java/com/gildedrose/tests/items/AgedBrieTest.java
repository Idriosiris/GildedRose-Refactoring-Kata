package com.gildedrose.tests.items;

import com.gildedrose.AgedBrie;
import com.gildedrose.GildedRoseShop;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    private GildedRoseShop app;

    private GildedRoseShop gildedRose(Item[] item) {
        return new GildedRoseShop(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void agedBrieIncreasesInQuality() {
        app = gildedRose(withItems(
                new AgedBrie(10, 10)
        ));

        app.update();

        assertEquals(11, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void agedBrieDoublesInQualityWhenSellinDayPasses() {
        app = gildedRose(withItems(
                new AgedBrie(0, 10)
        ));

        app.update();

        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        app = gildedRose(withItems(
                new AgedBrie(0, 50)
        ));

        app.update();

        assertEquals(50, app.items[0].quality);
    }
}
