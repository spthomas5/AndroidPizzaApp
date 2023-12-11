package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Deluxe pizza, which is a subclass of the Pizza class.
 * This class initializes the toppings and sauce for a Deluxe pizza and provides the price calculation
 *
 * @author [Adam Trabelsi, Sean Thomas]
 */

public class Deluxe extends Pizza
{
    /**
     * Constructs a Deluxe pizza with predefined toppings and sauce.
     * Initializes the toppings list with sausage, pepperoni, ham, green pepper, onion, black olive, and mushroom.
     * Sets the sauce to tomato.
     */
    public Deluxe() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.SAUSAGE,
                Topping.PEPPERONI,
                Topping.HAM,
                Topping.GREEN_PEPPER,
                Topping.ONION,
                Topping.BLACK_OLIVE,
                Topping.MUSHROOM
        ));
        this.sauce = Sauce.TOMATO;
    }

     /**
     * Calculates and returns the price of the Deluxe pizza.
     * The price includes base fees and the fixed base price of $14.99.
     * 
     * @return the total price of the Deluxe pizza.
     */
    @Override
    public double price() {
        return this.calculateFees() + 14.99;
    }

    @Override
    public String name() {
        return "Deluxe Pizza";
    }
}
