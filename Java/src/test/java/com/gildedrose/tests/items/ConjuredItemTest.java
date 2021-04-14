package com.gildedrose.tests.items;

import com.gildedrose.items.Conjured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private Conjured conjured;

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItems() {
        conjured = new Conjured(4, 10);

        Conjured updatedConjuredItem = conjured.update();

        assertEquals(8, updatedConjuredItem.quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItemsAlsoWhenSellInIs0() {
        conjured = new Conjured(0, 10);

        Conjured updatedConjuredItem = conjured.update();

        assertEquals(6, updatedConjuredItem.quality);
    }
}
