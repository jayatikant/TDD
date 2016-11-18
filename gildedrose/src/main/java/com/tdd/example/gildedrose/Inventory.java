package com.tdd.example.gildedrose;


class Inventory {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
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
		
		if (!AGED_BRIE.equals(item.name)
		        && !BACKSTAGE_PASSES.equals(item.name)) {
		    updateIfNotAgedBrieAndBackstagePasses(item);
		} else {
		    updateIfAgedBrieAndBackstagePasses(item);
		}

		if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
		    item.sellBy = item.sellBy - 1;
		}

		if (item.sellBy < 0) {
		    updateIfExpired(item);
		}
	}

	private void updateIfNotAgedBrieAndBackstagePasses(Item item) {
		if (item.quality > 0) {
		    if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
		        item.quality = item.quality - 1;
		    }
		}
	}

	private void updateIfExpired(Item item) {
		if (!item.name.equals(AGED_BRIE)) {
		    updateIfNotAgedBrie(item);
		} else {
		    incrementQualityIfNotMax(item);
		}
	}

	private void updateIfNotAgedBrie(Item item) {
		if (!BACKSTAGE_PASSES.equals(item.name)) {
		    updateIfNotBackStagePasses(item);
		} else {
		    item.quality = item.quality - item.quality;
		}
	}

	private void updateIfNotBackStagePasses(Item item) {
		if (item.quality > 0) {
		    if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
		        item.quality = item.quality - 1;
		    }
		}
	}

	private void updateIfAgedBrieAndBackstagePasses(Item item) {
		if (item.quality < 50) {
		    item.quality = item.quality + 1;

		    if (BACKSTAGE_PASSES.equals(item.name)) {
		        updateIfBackStagePasses(item);
		    }
		}
	}

	private void updateIfBackStagePasses(Item item) {
		if (item.sellBy < 11) {
		    incrementQualityIfNotMax(item);
		}

		if (item.sellBy < 6) {
		    incrementQualityIfNotMax(item);
		}
	}

	private void incrementQualityIfNotMax(Item item) {
		if (item.quality < 50) {
		    item.quality = item.quality + 1;
		}
	}
}