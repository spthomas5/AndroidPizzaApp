package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class Fire extends Pizza {
    public Fire() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.PEPPERONI,
                Topping.JALAPENOS,
                Topping.SAUSAGE
        ));
        this.sauce = Sauce.TOMATO;
    }

    @Override
    public double price() {
        return 10.22;
    }

    @Override
    public String name() {
        return "The Fire Pizza";
    }
}
