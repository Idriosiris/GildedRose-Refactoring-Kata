package com.gildedrose.tests.items;

import com.gildedrose.items.AgedBrie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    private AgedBrie agedBrie;

    @Test
    void agedBrieIncreasesInQuality() {
        agedBrie = new AgedBrie(10, 10);

        AgedBrie updatedAgedBrie = agedBrie.update();

        assertEquals(11, updatedAgedBrie.quality);
        assertEquals(9,  updatedAgedBrie.sellIn);
    }

    @Test
    void agedBrieDoublesInQualityWhenSellinDayPasses() {
        agedBrie = new AgedBrie(0, 10);

        AgedBrie updatedAgedBrie = agedBrie.update();

        assertEquals(12, updatedAgedBrie.quality);
        assertEquals(-1, updatedAgedBrie.sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        agedBrie = new AgedBrie(0, 50);

        AgedBrie updatedAgedBrie = agedBrie.update();

        assertEquals(50, updatedAgedBrie.quality);
    }
}
