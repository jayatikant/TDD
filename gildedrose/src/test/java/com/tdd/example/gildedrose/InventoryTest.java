package com.tdd.example.gildedrose;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

	@Test
	public void sellByDateAndQualityAreLowered() {
		Item[] items = new Item[] { new Item("foo", 3, 50) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(2, inventory.items[0].sellBy);
		assertEquals(49, inventory.items[0].quality);
	}

	@Test
	public void sellByDateAndQualityAreLoweredTwice() {
		Item[] items = new Item[] { new Item("foo", 3, 50) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		inventory.updateStock();
		assertEquals(1, inventory.items[0].sellBy);
		assertEquals(48, inventory.items[0].quality);
	}

	@Test
	public void qualityDegradesTwicePastsellByDate() {
		Item[] items = new Item[] { new Item("foo", 1, 50) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		inventory.updateStock();
		assertEquals(-1, inventory.items[0].sellBy);
		assertEquals(47, inventory.items[0].quality);
	}

	@Test
	public void qualityIsNeverNegative() {
		Item[] items = new Item[] { new Item("foo", 1, 1) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		inventory.updateStock();
		assertEquals(-1, inventory.items[0].sellBy);
		assertEquals(0, inventory.items[0].quality);
	}

	@Test
	public void agedBrieIncreasesInQualityWithAge() {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(1, inventory.items[0].sellBy);
		assertEquals(2, inventory.items[0].quality);
	}

	// @Test
	// public void qualityIsNeverMoreThan50(){
	// Item[] items = new Item[] {new Item ("foo", 1, 55)};
	// Inventory inventory = new Inventory(items);
	// Inventory.updateQuality();
	// assertEquals(0, inventory.items[0].sellBy);
	// assertEquals(54, inventory.items[0].quality);
	// }

	@Test
	public void sulfurasDoesntSellOrDescreaseInQuality() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 1) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(1, inventory.items[0].sellBy);
		assertEquals(1, inventory.items[0].quality);
	}

	@Test
	public void backstagePassIncreasesInQuality() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 20, 1) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(19, inventory.items[0].sellBy);
		assertEquals(2, inventory.items[0].quality);
	}

	@Test
	public void updateStock_QualityIsNeverNegative() {

		Item[] items = new Item[] { new Item("Testitem", 30, 0) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		Assert.assertEquals(0, inventory.items[0].quality);
	}

	public void backstagePassIncreasesInQualityBy2() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 9, 1) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(8, inventory.items[0].sellBy);
		assertEquals(3, inventory.items[0].quality);
	}

	@Test
	public void backstagePassIncreasesInQualityBy3() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 4, 1) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(3, inventory.items[0].sellBy);
		assertEquals(4, inventory.items[0].quality);
	}

	@Test
	public void backstagePassQualityDropsToZeroAfterConcert() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 0, 10) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(-1, inventory.items[0].sellBy);
		assertEquals(0, inventory.items[0].quality);
	}

	@Test
	public void agedBrieIncreasesInQualityAfterSellByDate() {
		Item[] items = new Item[] { new Item("Aged Brie", -1, 10) };
		Inventory inventory = new Inventory(items);
		inventory.updateStock();
		assertEquals(-2, inventory.items[0].sellBy);
		assertEquals(12, inventory.items[0].quality);
	}
}
