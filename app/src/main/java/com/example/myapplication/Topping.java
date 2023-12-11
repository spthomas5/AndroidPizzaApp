package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enum representing various pizza toppings.
 * Provides methods for retrieving image paths, getting a topping based on a value,
 * and obtaining a list of topping names.
 * 
 * Each topping has an associated image path
 * 
 * @author [Adam Trabelsi]
 */
public enum Topping {
    SAUSAGE,
    PEPPERONI,
    GREEN_PEPPER,
    ONION,
    MUSHROOM,
    BLACK_OLIVE,
    BEEF,
    HAM,
    SHRIMP,
    CRAB_MEAT,
    CHICKEN,
    JALAPENOS,
    ANCHOVIES,
    SQUID;

    /**
     * Retrieves the image path associated with the topping
     * 
     * @return The image path of the topping.
     */
    public String imagePath() {
        return switch (this) {
            case SAUSAGE -> "/images/sausages.png";
            case PEPPERONI -> "/images/pepp.png";
            case GREEN_PEPPER -> "/images/peppers.png";
            case ONION -> "/images/cry.png";
            case MUSHROOM -> "/images/mush.png";
            case BLACK_OLIVE -> "/images/olive.png";
            case BEEF -> "/images/beef.png";
            case HAM -> "/images/ham.png";
            case SHRIMP -> "/images/shrimp.png";
            case CRAB_MEAT -> "/images/crab.png";
            case CHICKEN -> "/images/chick.png";
            case JALAPENOS -> "/images/har.png";
            case ANCHOVIES -> "/images/houta.png";
            case SQUID -> "/images/squid.png";
        };
    }

    /*
     * Retrieves the Topping based on the provided value.
     *
     * @param value The value representing the topping.
     * @return The Topping associated with the provided value.
     */
    public static Topping get(String value) {
        for (Topping t : values()) {
            if (value.equalsIgnoreCase(t.name())) {
                return t;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of names for all toppings.
     * 
     * @return An ArrayList containing the names of all toppings.
     */
    public static ArrayList<String> toppingNames() {
        Topping[] toppings = values();
        String[] names = new String[toppings.length];

        for (int i = 0; i < toppings.length; i++) {
            String name = toppings[i].name().toLowerCase();
            names[i] = name.substring(0, 1).toUpperCase() + name.substring(1);
        }

        return new ArrayList<>(Arrays.asList(names));
    }
}
