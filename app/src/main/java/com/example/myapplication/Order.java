package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents an order containing a cart of pizzas.
 * Each order has an id and a list of pizzas in the cart.
 * 
 * The cart is initially empty and can be filled with pizzas using the addToCart method.
 * The id is incremented each time a pizza is added to the cart.
 * The cart can be reset using the resetCart method.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public class Order {
    private int id;
    private static final double TAX_RATE = 0.06625;

    private ArrayList<Pizza> cart;


    /**
     * Constructs an order with an empty cart.
     */
    public Order(int id) {
        this.cart = new ArrayList<Pizza>();
        this.id = id;
    }

    /**
     * Adds a pizza to the cart and increments the order id.
     * 
     * @param pizza the pizza to be added to the cart.
     */
    public void addToCart(Pizza pizza){
        this.cart.add(pizza);
    }

    /**
     * Retrieves the list of pizzas in the cart.
     * 
     * @return the list of pizzas in the cart.
     */
    public ArrayList<Pizza> getCart(){
        return this.cart;
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Order #" + this.id + ":\n");
        double total = 0.0;
        for (Pizza p : this.cart) {
            total += p.price();
            result.append(p.toString()).append("\n");
        }
        result.append("\n\nTotal Price: " + total + "\n\nTotal Price with Tax: "
                + (total * (1+ TAX_RATE) ));
        return result.toString();
    }
}
