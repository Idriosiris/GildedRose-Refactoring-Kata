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

        assertEquals(11, agedBrie.quality());
        assertEquals(9 , agedBrie.sellIn());
    }

    @Test
    void agedBrieDoublesInQualityWhenSellInDayPasses() {
        agedBrie = new AgedBrie(0, 10);

        AgedBrie updatedAgedBrie = agedBrie.update();

        assertEquals(12, agedBrie.quality());
        assertEquals(-1, agedBrie.sellIn());
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        agedBrie = new AgedBrie(0, 50);

        AgedBrie updatedAgedBrie = agedBrie.update();

        assertEquals(50, agedBrie.quality());
    }
}
