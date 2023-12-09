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
        for (Pizza p : this.cart) {
            result.append(p.toString()).append("\n");
        }
        return result.toString();
    }
}
