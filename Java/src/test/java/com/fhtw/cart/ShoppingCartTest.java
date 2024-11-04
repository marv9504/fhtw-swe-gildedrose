package com.fhtw.cart;

import com.fhtw.core.Item;
import com.fhtw.pricing.DefaultPricingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTest {

    private ShoppingCart cart;
    private CurrencyConverter currencyConverter;

    @BeforeEach
    void setUp() {
        currencyConverter = new CurrencyConverter();
        cart = new ShoppingCart(new DefaultPricingStrategy(), currencyConverter);
    }

    @Test
    void addItem() {
        Item item = new Item("Test Item", 10, 5, 20.0, 2);
        cart.addItem(item);
        assertTrue(cart.getItems().contains(item), "Item should be added to the cart.");
    }

    @Test
    void removeItem() {
        Item item = new Item("Test Item", 10, 5, 20.0, 2);
        cart.addItem(item);
        cart.removeItem(item);
        assertFalse(cart.getItems().contains(item), "Item should be removed from the cart.");
    }

    @Test
    void calculateTotalInEUR() {
        Item item1 = new Item("Test Item 1", 10, 5, 20.0, 2);
        Item item2 = new Item("Test Item 2", 15, 3, 30.0, 1);
        cart.addItem(item1);
        cart.addItem(item2);

        double expectedTotal = (20.0 * 2) + (30.0 * 1);
        double actualTotal = cart.calculateTotal("EUR");
        assertEquals(expectedTotal, actualTotal, "Total should be calculated correctly in EUR.");
    }

    @Test
    void calculateTotalInUSD() {
        Item item1 = new Item("Test Item 1", 10, 5, 20.0, 2);
        Item item2 = new Item("Test Item 2", 15, 3, 30.0, 1);
        cart.addItem(item1);
        cart.addItem(item2);

        double expectedTotalEUR = (20.0 * 2) + (30.0 * 1);
        double expectedTotalUSD = currencyConverter.convertPrice(expectedTotalEUR, "USD");
        double actualTotal = cart.calculateTotal("USD");

        assertEquals(expectedTotalUSD, actualTotal, "Total should be calculated and converted to USD correctly.");
    }
}
