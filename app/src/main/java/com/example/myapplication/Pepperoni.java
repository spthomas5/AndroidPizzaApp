package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Pepperoni pizza, which is a subclass of the Pizza class.
 * This class initializes the toppings and sauce for a Pepperoni pizza and provides the price calculation.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public class Pepperoni extends Pizza{
    /**
     * Constructs a Pepperoni pizza.
     * Initializes the toppings list with pepperoni.
     * Sets the sauce to Tomato.
     */
    public Pepperoni() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.PEPPERONI
        ));
        this.sauce = Sauce.TOMATO;
    }
    /**
     * Calculates and returns the price of the Pepperoni pizza.
     * The price includes base fees and the fixed base price of $10.99.
     * 
     * @return the total price of the Pepperoni pizza.
     */
    @Override
    public double price() {
        return this.calculateFees() + 10.99;
    }

    @Override
    public String name() {
        return "Pepperoni Pizza";
    }
}
