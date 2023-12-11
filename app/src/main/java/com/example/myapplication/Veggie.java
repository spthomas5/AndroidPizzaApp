package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class Veggie extends Pizza {
    public Veggie() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.PEPPERONI,
                Topping.MUSHROOM,
                Topping.ONION
        ));
        this.sauce = Sauce.ALFREDO;
    }

    @Override
    public double price() {
        return 7.99;
    }

    @Override
    public String name() {
        return "Veggie Pizza";
    }
}
