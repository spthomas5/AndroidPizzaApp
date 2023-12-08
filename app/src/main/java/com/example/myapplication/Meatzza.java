package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Meatzza pizza, which is a subclass of the Pizza class.
 * This class initializes the toppings and sauce for a Meatzza pizza and provides the price calculation.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public class Meatzza extends Pizza{
    /**
     * Constructs a Meatzza pizza with predefined toppings and sauce.
     * Initializes the toppings list with sausage, pepperoni, beef, and ham.
     * Sets the sauce to Alfredo.
     */
    public Meatzza() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.SAUSAGE,
                Topping.PEPPERONI,
                Topping.BEEF,
                Topping.HAM
        ));
        this.sauce = Sauce.ALFREDO;
    }
    /**
     * Calculates and returns the price of the Meatzza pizza.
     * The price includes base fees and the fixed base price of $16.99.
     * 
     * @return the total price of the Meatzza pizza.
     */
    @Override
    public double price() {
        return this.calculateFees() + 16.99;
    }
}
