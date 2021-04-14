package com.gildedrose.tests.items;

import com.gildedrose.items.SimpleItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleItemTest {

    private SimpleItem simpleItem;

    @Test
    void foo() {
        simpleItem = new SimpleItem("foo", 0, 0);

        SimpleItem updatedSimpleItem = simpleItem.update();

        assertEquals("foo", updatedSimpleItem.name);
    }

    @Test
    void decrementQualityAndSellInAfterOneDay() {
        SimpleItem simpleItem = new SimpleItem("item", 10, 10);

        SimpleItem updatedSimpleItem = simpleItem.update();

        assertEquals(9, updatedSimpleItem.quality());
        assertEquals(9, updatedSimpleItem.sellIn());
    }

    @Test
    void qualityDegradesTwiceAsFastOnceTheSellByDateHasPassed() {
        simpleItem = new SimpleItem("item", 0, 10);

        SimpleItem updatedSimpleItem = simpleItem.update();

        assertEquals(8, updatedSimpleItem.quality());
        assertEquals(-1, updatedSimpleItem.sellIn());
    }

    @Test
    void TestThatQualityIsNeverNegative() {
        SimpleItem simpleItem = new SimpleItem("item", 0, 1);

        SimpleItem updatedSimpleItem = simpleItem.update();

        assertEquals(0, updatedSimpleItem.quality());
        assertEquals(-1, updatedSimpleItem.sellIn());
    }
}
