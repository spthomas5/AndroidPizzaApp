package com.example.myapplication;

    /**
    * Enum class for sauce types
    * @author [Adam Trabelsi, Sean Thomas]
    */
public enum Sauce {
    TOMATO,
    ALFREDO;

    /*
     * Retrieves the Sauce based on the provided value.
     *
     * @param value The value representing the sauce.
     * @return The Sauce associated with the provided value.
     */
    public static Sauce get(String value) {
        for (Sauce s : values()) {
            if (value.equalsIgnoreCase(s.name())) {
                return s;
            }
        }
        return null;
    }
}
