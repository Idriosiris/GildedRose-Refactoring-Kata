package com.gildedrose.tests.items;

import com.gildedrose.Conjured;
import com.gildedrose.GildedRoseShop;
import com.gildedrose.SimpleItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private SimpleItem simple;
    private Conjured conjured;

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItems() {
        simple = new SimpleItem("Simple", 4, 10);
        conjured = new Conjured(4, 10);

        simple.update();
        conjured.update();

        assertEquals(9, simple.quality);
        assertEquals(8, conjured.quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsSimpleItemsAlsoWhenSellInIs0() {
        simple = new SimpleItem("Simple", 0, 10);
        conjured = new Conjured(0, 10);

        simple.update();
        conjured.update();

        assertEquals(8, simple.quality);
        assertEquals(6, conjured.quality);
    }
}
