package com.tdd.example.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
	
	@Test
	public void updateQuality_QualityIsNeverNegative() {
		
		Item[] items = new Item[]{new Item("Testitem", 30, 0)};
		GildedRose gildedRose = new GildedRose(items );
		gildedRose.updateQuality();
		Assert.assertEquals(0, gildedRose.items[0].quality);
	}
}
