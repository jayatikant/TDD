package com.tdd.example.gildedrose;

public class Item {

    public String name;

    public int sellBy;

    public int quality;

    public Item(String name, int sellBy, int quality) {
        this.name = name;
        this.sellBy = sellBy;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellBy + ", " + this.quality;
    }
}