package com.fhtw.cart;

public class CurrencyConverter {

    public static final double USD_WECHSELKURS = 1.1;
    public static final double GBP_WECHSELKURS = 0.9;

    public double convertPrice(double price, String currency) {

        // Simples Demobeispiel
        switch (currency) {
            case "USD":
                return price * USD_WECHSELKURS;
            case "GBP":
                return price * GBP_WECHSELKURS;
            default:
                return price;
        }
    }
}

