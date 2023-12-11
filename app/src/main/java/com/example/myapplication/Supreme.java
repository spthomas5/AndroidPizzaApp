package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Supreme pizza.
 * Extends the Pizza class and provides implementation for the price calculation.
 * 
 * @author [Sean Thomas, Adam Trabelsi]
 */
public class Supreme extends Pizza{
     /**
     * Constructs a Supreme pizza with toppings and tomato sauce.
     */
    public Supreme() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.SAUSAGE,
                Topping.PEPPERONI,
                Topping.GREEN_PEPPER,
                Topping.ONION,
                Topping.MUSHROOM
        ));
        this.sauce = Sauce.TOMATO;
    }

    /**
     * Calculates the price of the Supreme pizza, including base price and additional fees for toppings and size.
     * 
     * @return The total price of the Supreme pizza.
     */
    @Override
    public double price() {
        return this.calculateFees() + 15.99;
    }

    @Override
    public String name() {
        return "Supreme Pizza";
    }
}
