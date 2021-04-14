package com.gildedrose.tests.items;

import com.gildedrose.GildedRoseShop;
import com.gildedrose.Item;
import com.gildedrose.Sulfuras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    private Sulfuras sulfuras;

    @Test
    void sulfurasNeverDecreasesInQuality() {
        sulfuras = new Sulfuras(2, 10);

        sulfuras.update();

        assertEquals(10, sulfuras.quality);
    }

    @Test
    void sulfurasSellinDayNeverDecreases() {
        sulfuras = new Sulfuras(2, 10);

        sulfuras.update();

        assertEquals(2, sulfuras.sellIn);
    }
}
