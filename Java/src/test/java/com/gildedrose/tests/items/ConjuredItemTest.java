package com.gildedrose.tests.items;

import com.gildedrose.Conjured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private Conjured conjured;

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItems() {
        conjured = new Conjured(4, 10);

        conjured.update();

        assertEquals(8, conjured.quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItemsAlsoWhenSellInIs0() {
        conjured = new Conjured(0, 10);

        conjured.update();

        assertEquals(6, conjured.quality);
    }
}
