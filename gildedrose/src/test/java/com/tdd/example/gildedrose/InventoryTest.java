package com.tdd.example.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {
	
	@Test
	public void updateStock_QualityIsNeverNegative() {
		
		Item[] items = new Item[]{new Item("Testitem", 30, 0)};
		Inventory gildedRose = new Inventory(items );
		gildedRose.updateStock();
		Assert.assertEquals(0, gildedRose.items[0].quality);
	}
}
