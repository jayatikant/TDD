package com.tdd.example.gildedrose;


class Inventory {
    Item[] items;

    public Inventory(Item[] items) {
        this.items = items;
    }

    public void updateStock() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

	private void updateItem(Item item) {
		
		if (!"Aged Brie".equals(item.name)
		        && !"Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
		    if (item.quality > 0) {
		        if (!"Sulfuras, Hand of Ragnaros".equals(item.name)) {
		            item.quality = item.quality - 1;
		        }
		    }
		} else {
		    updateIfNotAgedBrieAndBackstagePasses(item);
		}

		if (!"Sulfuras, Hand of Ragnaros".equals(item.name)) {
		    item.sellBy = item.sellBy - 1;
		}

		if (item.sellBy < 0) {
		    updateIfExpired(item);
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

	private void updateIfNotAgedBrieAndBackstagePasses(Item item) {
		if (item.quality < 50) {
		    item.quality = item.quality + 1;

		    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
		        if (item.sellBy < 11) {
		            if (item.quality < 50) {
		                item.quality = item.quality + 1;
		            }
		        }

		        if (item.sellBy < 6) {
		            if (item.quality < 50) {
		                item.quality = item.quality + 1;
		            }
		        }
		    }
		}
	}
}