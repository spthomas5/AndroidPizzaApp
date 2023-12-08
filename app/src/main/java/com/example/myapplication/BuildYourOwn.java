package com.example.myapplication;

/**
 * Represents a Build Your Own pizza, which is a subclass of the Pizza class.
 * This class calculates the price of a Build Your Own pizza based on the number
 * of included toppings, additional toppings, and associated pricing constants.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */

public class BuildYourOwn extends Pizza{
    private static final int NUM_INCLUDED_TOPPINGS = 3;
    private static final double TOPPING_PRICE = 1.49;
    private static final double INCLUDED_TOPPINGS_PRICE = 8.99;
    @Override
    public double price() {
        return this.calculateFees()
                + INCLUDED_TOPPINGS_PRICE
                + ((double)(this.toppings.size() - NUM_INCLUDED_TOPPINGS)) * TOPPING_PRICE ;
    }
}
