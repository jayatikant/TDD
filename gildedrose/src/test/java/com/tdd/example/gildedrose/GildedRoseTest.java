package com.tdd.example.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
	}

	@Test
	public void sellInDateAndQualityAreLowered() {
		Item[] items = new Item[] { new Item("foo", 3, 50) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(2, gildedRose.items[0].sellIn);
		assertEquals(49, gildedRose.items[0].quality);
	}

	@Test
	public void sellInDateAndQualityAreLoweredTwice() {
		Item[] items = new Item[] { new Item("foo", 3, 50) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		gildedRose.updateQuality();
		assertEquals(1, gildedRose.items[0].sellIn);
		assertEquals(48, gildedRose.items[0].quality);
	}

	@Test
	public void qualityDegradesTwicePastSellInDate() {
		Item[] items = new Item[] { new Item("foo", 1, 50) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		gildedRose.updateQuality();
		assertEquals(-1, gildedRose.items[0].sellIn);
		assertEquals(47, gildedRose.items[0].quality);
	}

	@Test
	public void qualityIsNeverNegative() {
		Item[] items = new Item[] { new Item("foo", 1, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		gildedRose.updateQuality();
		assertEquals(-1, gildedRose.items[0].sellIn);
		assertEquals(0, gildedRose.items[0].quality);
	}

	@Test
	public void agedBrieIncreasesInQualityWithAge() {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(1, gildedRose.items[0].sellIn);
		assertEquals(2, gildedRose.items[0].quality);
	}

	// @Test
	// public void qualityIsNeverMoreThan50(){
	// Item[] items = new Item[] {new Item ("foo", 1, 55)};
	// GildedRose gildedRose = new GildedRose(items);
	// gildedRose.updateQuality();
	// assertEquals(0, gildedRose.items[0].sellIn);
	// assertEquals(54, gildedRose.items[0].quality);
	// }

	@Test
	public void sulfurasDoesntSellOrDescreaseInQuality() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(1, gildedRose.items[0].sellIn);
		assertEquals(1, gildedRose.items[0].quality);
	}
	
	@Test
	public void backstagePassIncreasesInQuality(){
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(19, gildedRose.items[0].sellIn);
		assertEquals(2, gildedRose.items[0].quality);
	}
	

	@Test
	public void backstagePassIncreasesInQualityBy2(){
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(8, gildedRose.items[0].sellIn);
		assertEquals(3, gildedRose.items[0].quality);
	}
	

	@Test
	public void backstagePassIncreasesInQualityBy3(){
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 1) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(3, gildedRose.items[0].sellIn);
		assertEquals(4, gildedRose.items[0].quality);
	}
	

	@Test
	public void backstagePassQualityDropsToZeroAfterConcert(){
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(-1, gildedRose.items[0].sellIn);
		assertEquals(0, gildedRose.items[0].quality);
	}
	
	
	
	
	
	

}