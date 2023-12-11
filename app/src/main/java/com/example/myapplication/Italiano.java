package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class Italiano extends Pizza {


    public Italiano() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.BLACK_OLIVE,
                Topping.JALAPENOS,
                Topping.SAUSAGE
        ));
        this.sauce = Sauce.TOMATO;
    }

    @Override
    public double price() {
        return 5.99;
    }

    @Override
    public String name() {
        return "Italiano Pizza";
    }
}
