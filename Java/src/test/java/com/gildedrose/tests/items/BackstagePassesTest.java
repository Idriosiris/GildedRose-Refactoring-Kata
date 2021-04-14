package com.gildedrose.tests.items;

import com.gildedrose.items.BackstagePasses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {
    private BackstagePasses backstagePasses;

    @Test
    void backstagePassesIncreaseInQuality() {
        backstagePasses = new BackstagePasses(15, 10);

        BackstagePasses updatedBackStagePass = backstagePasses.update();

        assertEquals(11, updatedBackStagePass.quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByTwoIfSellInIsLowerThen10() {
        backstagePasses = new BackstagePasses(10, 10);

        BackstagePasses updatedBackStagePass = backstagePasses.update();

        assertEquals(12, updatedBackStagePass.quality);
    }

    @Test
    void backstagePassesIncreaseInQualityByThreeIfSellInIsLowerThen5() {
        backstagePasses = new BackstagePasses(5, 10);

        BackstagePasses updatedBackStagePass = backstagePasses.update();

        assertEquals(13, updatedBackStagePass.quality);
    }

    @Test
    void backstagePassesDropsTo0AfterConcert() {
        backstagePasses = new BackstagePasses(0, 10);

        BackstagePasses updatedBackStagePass = backstagePasses.update();

        assertEquals(0, updatedBackStagePass.quality);
    }
}
