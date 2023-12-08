package com.example.myapplication;

import java.util.ArrayList;

/**
 * Manages and stores a collection of orders for a store.
 * Provides methods for adding orders, retrieving orders, and exporting order information.
 * Each order is associated with an ID
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public class StoreOrders {
    private ArrayList<Order> orders;

    protected static int id = 1;

    /**
     * Constructs a new StoreOrders object with an empty list of orders.
     */
    public StoreOrders() {
        this.orders = new ArrayList<Order>();
    }


    /**
     * Adds an order to the collection.
     * 
     * @param order The order to be added.
     */
    public void addOrder(Order order) {
        orders.add(order);
        id++;
    }

     /**
     * Retrieves the list of orders stored in the collection.
     * 
     * @return The list of orders.
     */
    public ArrayList<Order> getOrders(){
        return this.orders;
    }

    public void export(){
        //todo
    }
}
