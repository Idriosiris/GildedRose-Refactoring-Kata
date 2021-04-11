package com.gildedrose;

class GildedRose {
    SimpleItem[] simpleItems;

    public GildedRose(SimpleItem[] simpleItems) {
        this.simpleItems = simpleItems;
    }

    public void updateQuality() {
        for (SimpleItem simpleItem : simpleItems) {
            simpleItem.updateQualityAndSellIn();
        }
    }

}
