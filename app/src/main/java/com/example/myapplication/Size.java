package com.example.myapplication;

/**
 * Enum representing different sizes for pizzas.
 * Sizes include SMALL, MEDIUM, and LARGE.
 * 
 * @author [Sean Thomas]
 */
public enum Size {
    SMALL,
    MEDIUM,
    LARGE;

    /*
     * Retrieves the Size based on the provided value.
     *
     * @param value The value representing the size.
     * @return The Size associated with the provided value.
     */
    public static Size get(String value) {
        for (Size s : values()) {
            if (value.equalsIgnoreCase(s.name())) {
                return s;
            }
        }
        return null;
    }
}
