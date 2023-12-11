package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Seafood pizza, which is a subclass of the Pizza class.
 * This class initializes the toppings and sauce for a Seafood pizza and provides the price calculation.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public class Seafood extends Pizza{

    public Seafood() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.SHRIMP,
                Topping.SQUID,
                Topping.CRAB_MEAT
        ));
        this.sauce = Sauce.ALFREDO;
    }

    /**
     * Calculates and returns the price of the Seafood pizza.
     * The price includes base fees and the fixed base price of $17.99.
     * 
     * @return the total price of the Seafood pizza.
     */
    @Override
    public double price() {
        return this.calculateFees() + 17.99;
    }

    @Override
    public String name() {
        return "Seafood Pizza";
    }
}
