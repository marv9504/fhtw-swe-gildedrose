package com.fhtw.cart;

import com.fhtw.core.Item;
import com.fhtw.pricing.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> items;
    private final PricingStrategy pricingStrategy;
    private final CurrencyConverter currencyConverter;

    public ShoppingCart(PricingStrategy pricingStrategy, CurrencyConverter currencyConverter) {
        this.items = new ArrayList<>();
        this.pricingStrategy = pricingStrategy;
        this.currencyConverter = currencyConverter;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal(String currency) {
        double total = 0;
        for (Item item : items) {
            total += pricingStrategy.calculatePrice(item);
        }
        return currencyConverter.convertPrice(total, currency);
    }

    public List<Item> getItems() {
        return items;
    }

}
