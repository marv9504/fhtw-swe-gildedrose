package com.fhtw.core;

public class Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    private String name;
    private int quality;
    private int sellIn;
    private double price;
    private int quantity;

    public Item(String name, int quality, int sellIn, double price, int quantity) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decreaseSellInByOne() {
        this.sellIn--;
    }

    public void increaseQualityBy(int increment) {
        this.quality = Math.min(this.quality + increment, MAX_QUALITY);
    }

    public void decreaseQualityByOne() {
        if (this.quality > MIN_QUALITY) {
            this.quality--;
        }
    }
}
