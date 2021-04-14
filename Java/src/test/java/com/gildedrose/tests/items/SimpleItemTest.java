package com.gildedrose.tests.items;

import com.gildedrose.items.SimpleItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleItemTest {

    private SimpleItem simpleItem;

    @Test
    void foo() {
        simpleItem = new SimpleItem("foo", 0, 0);

        simpleItem.update();

        assertEquals("foo", simpleItem.name);
    }

    @Test
    void decrementQualityAndSellInAfterOneDay() {
        SimpleItem simpleItem = new SimpleItem("item", 10, 10);

        simpleItem.update();

        assertEquals(9, simpleItem.quality);
        assertEquals(9, simpleItem.sellIn);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceTheSellByDateHasPassed() {
        simpleItem = new SimpleItem("item", 0, 10);

        simpleItem.update();

        assertEquals(8, simpleItem.quality);
        assertEquals(-1, simpleItem.sellIn);
    }

    @Test
    void TestThatQualityIsNeverNegative() {
        SimpleItem simpleItem = new SimpleItem("item", 0, 1);

        simpleItem.update();

        assertEquals(0, simpleItem.quality);
        assertEquals(-1, simpleItem.sellIn);
    }
}
