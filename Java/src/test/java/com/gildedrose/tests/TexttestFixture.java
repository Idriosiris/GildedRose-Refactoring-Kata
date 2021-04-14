package com.gildedrose.tests;

import com.gildedrose.GildedRoseShop;
import com.gildedrose.items.Item;
import com.gildedrose.items.SimpleItem;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        SimpleItem[] simpleItems = new SimpleItem[] {
                new SimpleItem("+5 Dexterity Vest", 10, 20), //
                new SimpleItem("Aged Brie", 2, 0), //
                new SimpleItem("Elixir of the Mongoose", 5, 7), //
                new SimpleItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                new SimpleItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new SimpleItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new SimpleItem("Conjured Mana Cake", 3, 6) };

        GildedRoseShop app = new GildedRoseShop(simpleItems);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : simpleItems) {
                System.out.println(item);
            }
            System.out.println();
            app.update();
        }
    }

}
