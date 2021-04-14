package com.gildedrose.tests;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.SimpleItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    private GildedRose gildedRose(Item[] item) {
        return new GildedRose(item);
    }

    private Item[] withItems(Item... item) {
        return item;
    }

    @Test
    void foo() {
        GildedRose app = gildedRose(withItems(
                new SimpleItem("foo", 0, 0))
        );

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }
}
