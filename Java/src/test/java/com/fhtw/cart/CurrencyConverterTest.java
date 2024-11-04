package com.fhtw.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConverterTest {

    private CurrencyConverter currencyConverter;

    @BeforeEach
    void setUp() {
        currencyConverter = new CurrencyConverter();
    }

    @Test
    void convertPriceToUSD() {
        double priceInEUR = 100.0;
        double expectedPriceInUSD = 100.0 * 1.1; // Assuming 1 EUR = 1.1 USD
        double actualPriceInUSD = currencyConverter.convertPrice(priceInEUR, "USD");
        assertEquals(expectedPriceInUSD, actualPriceInUSD, 0.01, "Price should be converted to USD correctly.");
    }

    @Test
    void convertPriceToGBP() {
        double priceInEUR = 100.0;
        double expectedPriceInGBP = 100.0 * 0.9; // Assuming 1 EUR = 0.9 GBP
        double actualPriceInGBP = currencyConverter.convertPrice(priceInEUR, "GBP");
        assertEquals(expectedPriceInGBP, actualPriceInGBP, 0.01, "Price should be converted to GBP correctly.");
    }

    @Test
    void convertPriceToEUR() {
        double priceInEUR = 100.0;
        double actualPriceInEUR = currencyConverter.convertPrice(priceInEUR, "EUR");
        assertEquals(priceInEUR, actualPriceInEUR, "Price in EUR should remain the same without conversion.");
    }
}
