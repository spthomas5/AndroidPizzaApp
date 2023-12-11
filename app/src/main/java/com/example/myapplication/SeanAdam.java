package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class SeanAdam extends Pizza{

    public SeanAdam() {
        this.toppings = new ArrayList<>(Arrays.asList(
                Topping.CRAB_MEAT,
                Topping.CHICKEN,
                Topping.BEEF,
                Topping.SAUSAGE
        ));
        this.sauce = Sauce.TOMATO;
    }
    @Override
    public double price() {
        return 6.90;
    }

    @Override
    public String name() {
        return "The Sean Adam Special";
    }
}
