package com.tdd.example.gildedrose;


class Inventory {
    Item[] items;

    public Inventory(Item[] items) {
        this.items = items;
    }

    public void updateStock() {
        for (int i = 0; i < items.length; i++) {
            updateItem(i);
        }
    }

	private void updateItem(int i) {
		if (!items[i].name.equals("Aged Brie")
		        && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		    if (items[i].quality > 0) {
		        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
		            items[i].quality = items[i].quality - 1;
		        }
		    }
		} else {
		    updateIfNotAgedBrieAndBackstagePasses(i);
		}

		if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
		    items[i].sellBy = items[i].sellBy - 1;
		}

		if (items[i].sellBy < 0) {
		    updateIfExpired(items[i]);
		}
	}

	private void updateIfExpired(Item item) {
		if (!item.name.equals("Aged Brie")) {
		    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		        if (item.quality > 0) {
		            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		                item.quality = item.quality - 1;
		            }
		        }
		    } else {
		        item.quality = item.quality - item.quality;
		    }
		} else {
		    if (item.quality < 50) {
		        item.quality = item.quality + 1;
		    }
		}
	}

	private void updateIfNotAgedBrieAndBackstagePasses(int i) {
		if (items[i].quality < 50) {
		    items[i].quality = items[i].quality + 1;

		    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		        if (items[i].sellBy < 11) {
		            if (items[i].quality < 50) {
		                items[i].quality = items[i].quality + 1;
		            }
		        }

		        if (items[i].sellBy < 6) {
		            if (items[i].quality < 50) {
		                items[i].quality = items[i].quality + 1;
		            }
		        }
		    }
		}
	}
}