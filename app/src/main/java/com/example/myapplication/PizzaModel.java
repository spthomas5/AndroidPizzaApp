package com.example.myapplication;

public class PizzaModel {
    String pizzaName;
    String toppings;
    int image;

    public PizzaModel(String pizzaName, String toppings, int image) {
        this.pizzaName = pizzaName;
        this.toppings = toppings;
        this.image = image;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getToppings() {
        return toppings;
    }

    public int getImage() {
        return image;
    }
}
