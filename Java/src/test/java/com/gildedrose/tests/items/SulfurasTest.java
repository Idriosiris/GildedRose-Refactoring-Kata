package com.gildedrose.tests.items;

import com.gildedrose.GildedRoseShop;
import com.gildedrose.Item;
import com.gildedrose.Sulfuras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    private GildedRoseShop app;

    private GildedRoseShop gildedRose(Item[] item) {
        return new GildedRoseShop(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void sulfurasNeverDecreasesInQuality() {
        app = gildedRose(withItems(
                new Sulfuras(2, 10)
        ));

        app.update();

        assertEquals(10, app.items[0].quality);
    }

    @Test
    void sulfurasSellinDayNeverDecreases() {
        app = gildedRose(withItems(
                new Sulfuras(2, 10)
        ));

        app.update();

        assertEquals(2, app.items[0].sellIn);
    }
}
