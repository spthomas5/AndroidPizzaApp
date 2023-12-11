package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class Shrimp extends Pizza {
    public Shrimp() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.SHRIMP,
                Topping.CRAB_MEAT,
                Topping.PEPPERONI
        ));
        this.sauce = Sauce.TOMATO;
    }

    @Override
    public double price() {
        return 9.99;
    }

    @Override
    public String name() {
        return "Shrimp Pizza";
    }
}
