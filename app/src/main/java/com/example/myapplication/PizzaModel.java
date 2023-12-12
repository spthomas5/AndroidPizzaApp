package com.example.myapplication;

public class PizzaModel {
    String pizzaName;
    String toppings;
    int image;

    double basePrice;

    public PizzaModel(String pizzaName, String toppings, int image, double basePrice) {
        this.pizzaName = pizzaName;
        this.toppings = toppings;
        this.image = image;
        this.basePrice = basePrice;
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

    public double getBasePrice() {
        return basePrice;
    }
}
