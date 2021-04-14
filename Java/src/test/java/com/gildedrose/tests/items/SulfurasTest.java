package com.gildedrose.tests.items;

import com.gildedrose.items.Sulfuras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    private Sulfuras sulfuras;

    @Test
    void sulfurasNeverDecreasesInQuality() {
        sulfuras = new Sulfuras(2, 10);

        Sulfuras updatedSulfuras = sulfuras.update();

        assertEquals(10, updatedSulfuras.quality());
    }

    @Test
    void sulfurasSellInDayNeverDecreases() {
        sulfuras = new Sulfuras(2, 10);

        Sulfuras updatedSulfuras = sulfuras.update();

        assertEquals(2, updatedSulfuras.sellIn());
    }
}
